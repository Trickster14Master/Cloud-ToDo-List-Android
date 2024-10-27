package ru.example.cloudtodolistandroid.data.maper

import ru.example.cloudtodolistandroid.data.local.entity.NoteEntity
import ru.example.cloudtodolistandroid.domain.models.note.Note
import ru.example.cloudtodolistandroid.domain.models.note.NoteDto
import ru.example.cloudtodolistandroid.domain.models.note.NotePost
import ru.example.cloudtodolistandroid.domain.models.note.NotePostDto

fun NoteEntity.toNote():Note{
    return Note(
        id=id?:0,
        nameNote=nameNote,
        descriptionNote=descriptionNote,
        userToken=userToken
    )
}

fun Note.toNoteEntity():NoteEntity{
    return NoteEntity(
        id=id,
        nameNote = nameNote,
        descriptionNote = descriptionNote,
        userToken = userToken
    )
}

fun NoteDto.toNote():Note{
    return Note(
        id = id,
        nameNote = NameNote,
        descriptionNote = DescriptionNote,
        userToken = UserToken
    )
}

fun Note.toPostNote(): NotePostDto {
    return NotePostDto(
        NameNote = nameNote,
        DescriptionNote = descriptionNote,
        UserToken = userToken
    )
}

fun NoteDto.toNoteEntity():NoteEntity{
    return NoteEntity(
        id = id,
        nameNote = NameNote,
        descriptionNote = DescriptionNote,
        userToken = UserToken
    )
}