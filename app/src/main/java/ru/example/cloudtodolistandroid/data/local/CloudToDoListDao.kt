package ru.example.cloudtodolistandroid.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.example.cloudtodolistandroid.data.local.entity.NoteEntity

@Dao
interface CloudToDoListDao {
    @Query("SELECT * FROM noteentity")
    fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE id=:id")
    suspend fun getNoteByID(id:Int):NoteEntity?

    @Query("""
        SELECT *
        FROM noteentity
        WHERE LOWER(userToken) LIKE '%' || LOWER(:query)||'%' OR
            UPPER(:query) == userToken 
        
    """)
    suspend fun searchNote(query:String): List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListNote(note:List<NoteEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NoteEntity)

    @Query("DELETE FROM noteentity")
    suspend fun clearNoteList()

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}