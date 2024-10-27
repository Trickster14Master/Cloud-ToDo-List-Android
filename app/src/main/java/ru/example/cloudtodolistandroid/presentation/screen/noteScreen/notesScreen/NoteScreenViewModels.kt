package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.notesScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.example.cloudtodolistandroid.domain.repository.StockNoteRepository
import ru.example.cloudtodolistandroid.util.Resource
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModels @Inject constructor(
    private val repository: StockNoteRepository
):ViewModel() {
    var state by mutableStateOf(NoteScreenState())

    private var search: Job? = null

    init {

        getNoteListing()
    }

    fun OnEvent(event: NoteScreenEvent){
        when(event){
            is NoteScreenEvent.OnSearchQueryChange -> TODO()

            is NoteScreenEvent.Refresh -> {
                getNoteListing(fetchFromRemote = true)
            }

            is NoteScreenEvent.DeleteNode -> {
                viewModelScope.launch {
                    repository.deleteNote(event.note)
                }

            }
        }
    }

    fun getNoteListing(
        query: String = "root",
        fetchFromRemote: Boolean = false
    ){
        viewModelScope.launch {
            repository.getNotes(fetchFromRemote, query).collect{result ->
                when(result){
                    is Resource.Error -> {
                        result.data?.let { listing->
                            state = state.copy(
                                note = listing
                            )
                        }
                        Log.d("ViewModelNote", state.note.toString())
                    }
                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }
                    is Resource.Success -> {
                        result.data?.let { listing->
                            state = state.copy(
                                note = listing
                            )
                        }
                    }
                }

            }
        }
    }
}