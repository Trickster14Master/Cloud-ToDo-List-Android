package ru.example.cloudtodolistandroid.domain.models.taskforgroup

data class TaskForGroupPost(
    val userToken:String="",
    val nameTaskForGroup:String="",
    val descriptionTask:String="",
    val statusTaskForGroup:Boolean,
    val group:Int
)