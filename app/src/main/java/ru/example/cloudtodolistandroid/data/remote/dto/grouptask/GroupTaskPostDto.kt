package ru.example.cloudtodolistandroid.domain.models.grouptask

data class GroupTaskPostDto(
    val userToken:String="",
    val nameGroupTask:String="",
    val statusGroupTask:String="",
)
