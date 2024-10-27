package ru.example.cloudtodolistandroid.domain.models.taskforgroup

data class TaskForGroupPostDto(
    val userToken:String="",
    val nameTaskForGroup:String="",
    val descriptionTask:String="",
    val statusTaskForGroup:Boolean,
    val group:Int
)