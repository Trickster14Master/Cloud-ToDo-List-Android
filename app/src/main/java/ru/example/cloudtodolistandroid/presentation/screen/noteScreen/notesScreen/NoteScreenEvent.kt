package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.notesScreen

import ru.example.cloudtodolistandroid.domain.models.note.Note

sealed class NoteScreenEvent {
    object Refresh: NoteScreenEvent()
    data class OnSearchQueryChange(val query: String): NoteScreenEvent()
    data class DeleteNode(val note: Note):NoteScreenEvent()
}