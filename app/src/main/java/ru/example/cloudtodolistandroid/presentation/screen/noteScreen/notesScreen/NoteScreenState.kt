package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.notesScreen

import android.icu.text.StringSearch
import ru.example.cloudtodolistandroid.domain.models.note.Note

data class NoteScreenState(
    val note:List<Note> = emptyList(),
    val isRefreshing: Boolean = false,
    val isLoading: Boolean = false,
    val search: String = ""
)

