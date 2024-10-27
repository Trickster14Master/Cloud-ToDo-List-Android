package ru.example.cloudtodolistandroid.domain.models.note

data class NoteDto(
    val id: Int,
    val NameNote : String,
    val DescriptionNote  : String,
    val UserToken   : String,
)

data class NotePostDto(
    val NameNote : String="",
    val DescriptionNote  : String="",
    val UserToken   : String="",
)
