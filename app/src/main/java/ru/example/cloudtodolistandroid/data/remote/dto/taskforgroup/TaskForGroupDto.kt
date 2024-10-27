package ru.example.cloudtodolistandroid.domain.models.taskforgroup

data class TaskForGroupDto(
    val id:Int,
    val userToken:String,
    val nameTaskForGroup:String,
    val descriptionTask:String,
    val statusTaskForGroup:Boolean,
    val group:Int,
)