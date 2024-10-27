package ru.example.cloudtodolistandroid.domain.models.task

data class TaskDto(
    val id:Int,
    val userToken:String,
    val nameTask:String,
    val descriptionTask:String,
    val dataTask:String,
    val statusTask:Boolean,
    val fileForTask:String
)