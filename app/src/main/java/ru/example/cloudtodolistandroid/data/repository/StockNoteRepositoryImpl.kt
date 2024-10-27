package ru.example.cloudtodolistandroid.data.repository

import androidx.room.util.query
import coil.network.HttpException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okio.IOException
import ru.example.cloudtodolistandroid.data.local.CloudToDoListDB
import ru.example.cloudtodolistandroid.data.maper.toNote
import ru.example.cloudtodolistandroid.data.maper.toNoteEntity
import ru.example.cloudtodolistandroid.data.maper.toPostNote
import ru.example.cloudtodolistandroid.data.remote.StockAPI
import ru.example.cloudtodolistandroid.domain.models.note.Note
import ru.example.cloudtodolistandroid.domain.repository.StockNoteRepository
import ru.example.cloudtodolistandroid.util.BaseApiResponse
import ru.example.cloudtodolistandroid.util.Resource
import javax.inject.Inject

class StockNoteRepositoryImpl @Inject constructor(
    val api:StockAPI,
    val db: CloudToDoListDB,
):StockNoteRepository {

    private val dao = db.cloudToDoListDao

    override suspend fun getNotes(
        fetchFromRemote: Boolean,
        userToken: String
    ): Flow<Resource<List<Note>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListingNote=dao.searchNote(userToken)
            emit(
                Resource.Success(
                    data = localListingNote.map { it.toNote() }
                ))

            val isDBEmpty = localListingNote.isEmpty() && userToken.isEmpty()

            if (!isDBEmpty && !fetchFromRemote){
                emit(Resource.Loading(false))
                return@flow
            }

            try {
                val remoteNote = api.getNote(userToken)
                dao.clearNoteList()
                dao.insertListNote(remoteNote.map { it.toNoteEntity() })
            }catch (e:IOException){
                e.printStackTrace()
                emit(Resource.Error(e.toString()))
            }catch (e:HttpException){
                e.printStackTrace()
                emit(Resource.Error(e.toString()))
            }

            val remoteNote = api.getNote(userToken)
            emit(Resource.Success(remoteNote.map { it.toNote() }))
            
        }
    }

    override suspend fun getNoteById(id: Int): Resource<List<Note>> {
        return try {
            val result = api.getNote(id.toString())
            Resource.Success(result.map { it.toNote() })
        }catch (e:IOException){
            e.printStackTrace()
            return (Resource.Error(e.toString()))
        }catch (e:HttpException){
            e.printStackTrace()
            return (Resource.Error(e.toString()))
        }
    }

    override suspend fun insertNote(fetchFromRemote: Boolean, note: Note) {
        try{ api.postNote(note.toPostNote()) }
        catch (e:HttpException){
            dao.insertNote(note.toNoteEntity())
        }

    }

    override suspend fun deleteNote(note: Note) {
        try {
     api.deleteNode(note.id)
           dao.deleteNote(note.toNoteEntity())
        }catch (e: HttpException){
           dao.deleteNote(note.toNoteEntity())
        }

    }
}