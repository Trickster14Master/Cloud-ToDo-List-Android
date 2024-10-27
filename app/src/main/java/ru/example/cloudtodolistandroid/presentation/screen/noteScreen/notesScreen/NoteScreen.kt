package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.notesScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.example.cloudtodolistandroid.presentation.navigation.Route
import ru.example.cloudtodolistandroid.presentation.screen.noteScreen.widgets.NoteItem
import ru.example.cloudtodolistandroid.ui.theme.bac
import ru.example.cloudtodolistandroid.ui.theme.main_red
import ru.example.cloudtodolistandroid.ui.theme.primary

@Composable
fun NoteScreen(
    viewModels: NoteScreenViewModels = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing =viewModels.state.isRefreshing )
    val state = viewModels.state

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
                    FloatingActionButton(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 65.dp)
                .size(40.dp),
            onClick = {
                navController.navigate(Route.ADD_NOTE_SCREEN)
            },
            backgroundColor = primary,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, contentDescription = "")
        }
        }
    ) { padding->
        Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bac)
            .padding(padding)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModels.OnEvent(NoteScreenEvent.Refresh)
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.note){note ->
                    NoteItem(
                        note,
                        onDeleteClick = {
                        viewModels.OnEvent(NoteScreenEvent.DeleteNode(note))
                    })
                }
            }

        }
    }
}}