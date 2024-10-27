package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.addNoteScreen

data class NoteTextFieldState(
    var text: String="",
    val hint: String="",
    val isHintVisible: Boolean = true
)
