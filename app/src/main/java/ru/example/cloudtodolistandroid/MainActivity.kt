package ru.example.cloudtodolistandroid
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ru.example.cloudtodolistandroid.presentation.navigation.HomeNav
import ru.example.cloudtodolistandroid.presentation.screen.noteScreen.addNoteScreen.AddNoteScreen
import ru.example.cloudtodolistandroid.presentation.screen.taskScreen.AddTaskScreen
import ru.example.cloudtodolistandroid.ui.theme.CloudToDoListAndroidTheme
import ru.example.cloudtodolistandroid.ui.theme.bac

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudToDoListAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = bac
                ) {
                    HomeNav()
                    //AddNoteScreen()
                }
            }
        }
    }
}















