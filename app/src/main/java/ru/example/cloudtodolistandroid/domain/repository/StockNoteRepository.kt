package ru.example.cloudtodolistandroid.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.example.cloudtodolistandroid.domain.models.note.Note
import ru.example.cloudtodolistandroid.domain.models.user.UserToken
import ru.example.cloudtodolistandroid.util.Resource

interface StockNoteRepository {
    suspend fun getNotes(
        fetchFromRemote:Boolean,
        userToken: String
    ): Flow<Resource<List<Note>>>

    suspend fun getNoteById(id:Int): Resource<List<Note>>

    suspend fun insertNote(
        fetchFromRemote:Boolean,
        note: Note)

    suspend fun deleteNote(note: Note)

}