package ru.example.cloudtodolistandroid.presentation.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.example.cloudtodolistandroid.presentation.screen.fileScreen.FileScreen
import ru.example.cloudtodolistandroid.presentation.screen.groupTaskScreen.GroupTaskScreen
import ru.example.cloudtodolistandroid.presentation.screen.noteScreen.addNoteScreen.AddNoteScreen
import ru.example.cloudtodolistandroid.presentation.screen.noteScreen.notesScreen.NoteScreen
import ru.example.cloudtodolistandroid.presentation.screen.taskScreen.TaskScreen

@ExperimentalMaterialApi
@Composable
fun NavigationForHome(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "note_screen_route"){
        composable(route = Route.NOTE_SCREEN){
            NoteScreen(navController=navController)
        }
        composable(route = Route.ADD_NOTE_SCREEN){
            AddNoteScreen(navController=navController)
        }

        composable(route = Route.FILE_SCREEN){
            FileScreen()
        }
        composable(route = Route.TASK_SCREEN){
            TaskScreen()
        }
        composable(route = Route.GROUP_TASK_SCREEN){
            GroupTaskScreen()
        }
    }
}