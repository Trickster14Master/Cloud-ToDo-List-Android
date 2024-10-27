package ru.example.cloudtodolistandroid.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    val nameNote:String,
    val descriptionNote:String,
    val userToken: String,
    @PrimaryKey val id:Int?=null,
)