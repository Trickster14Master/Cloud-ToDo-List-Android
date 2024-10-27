package ru.example.cloudtodolistandroid.domain.models.fail

data class FileDto(
    val id: Int=0,
    var nameFile: String="",
    var fileUrl:String="",
    var userToken:String=""
)
