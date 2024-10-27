package ru.example.cloudtodolistandroid.domain.models.note

data class Note(
    val id: Int=0,
    val nameNote : String="",
    val descriptionNote  : String="",
    val userToken   : String="",
)

data class NotePost(
    val nameNote : String="",
    val descriptionNote  : String="",
    val userToken   : String="",
)
