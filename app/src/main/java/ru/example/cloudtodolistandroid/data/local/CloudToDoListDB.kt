package ru.example.cloudtodolistandroid.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import ru.example.cloudtodolistandroid.data.local.entity.NoteEntity


@Database(
    entities = [NoteEntity::class],
    version = 1
)

abstract class CloudToDoListDB:RoomDatabase(){
    abstract  val cloudToDoListDao:CloudToDoListDao

    companion object{
        const val DATABASE_NAME = "cloudtodolistdb"
    }
}