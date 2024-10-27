package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.addNoteScreen

sealed class AddNodeEvent {
    data class EnteredTitle(val value:String):AddNodeEvent()
    data class EnteredDescription(val value:String):AddNodeEvent()
    object SaveNode:AddNodeEvent()
}