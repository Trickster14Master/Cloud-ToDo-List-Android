package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.addNoteScreen

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.example.cloudtodolistandroid.domain.repository.StockNoteRepository
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import coil.network.HttpException
import kotlinx.coroutines.launch

@HiltViewModel
class AddViewModels @Inject constructor(
    val noteRepository: StockNoteRepository
):ViewModel() {
    private var _nameNote = mutableStateOf(NoteTextFieldState(hint = "Название"))
    var nameNote: State<NoteTextFieldState> = _nameNote

    private val _descriptionNote = mutableStateOf(NoteTextFieldState(hint = "Содержимое"))
    val descriptionNote: State<NoteTextFieldState> = _descriptionNote

    fun onEvent(event: AddNodeEvent){
        when(event){
            AddNodeEvent.SaveNode -> {
                viewModelScope.launch {
                    try {
                        noteRepository.insertNote(
                            note = ru.example.cloudtodolistandroid.domain.models.note.Note(nameNote = nameNote.value.text, descriptionNote = descriptionNote.value.text, userToken = "root"),
                            fetchFromRemote = true
                        )
                    }catch (e:HttpException){

                    }
                }
            }

            is AddNodeEvent.EnteredDescription -> {
                _descriptionNote.value = descriptionNote.value.copy(
                    text = event.value
                )
            }
            is AddNodeEvent.EnteredTitle -> {
                _nameNote.value = nameNote.value.copy(
                    text = event.value
                )
            }
        }
    }


}