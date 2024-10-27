package ru.example.cloudtodolistandroid.domain.models.grouptask

data class GroupTaskDto(
    val id:Int,
    val userToken:String,
    val nameGroupTask:String,
    val statusGroupTask:Boolean
)
