package ru.example.cloudtodolistandroid.presentation.screen.noteScreen.addNoteScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.example.cloudtodolistandroid.presentation.navigation.Route
import ru.example.cloudtodolistandroid.presentation.widget.MainButton
import ru.example.cloudtodolistandroid.presentation.widget.MainOutlinedTextField
import ru.example.cloudtodolistandroid.ui.theme.bac
import ru.example.cloudtodolistandroid.ui.theme.surface


@Composable
fun AddNoteScreen(
    viewModels: AddViewModels = hiltViewModel(),
    navController: NavController
) {

    Column(
        modifier= Modifier
            .padding(horizontal = 10.dp, vertical = 50.dp)
            .fillMaxSize()
            .background(bac),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(top = 50.dp)) {
            MainOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                valueUser = viewModels.nameNote.value.text,
                onNameChange = { viewModels.onEvent(AddNodeEvent.EnteredTitle(it)) },
                HintUser = "Имя заметки",
                UserIcon = Icons.Filled.Edit,
            )
            Text(text = "", modifier = Modifier.padding(top = 1.dp))
            MainOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                valueUser = viewModels.descriptionNote.value.text,
                onNameChange = { viewModels.onEvent(AddNodeEvent.EnteredDescription(it)) },
                HintUser = "Описание",
                UserIcon = Icons.Filled.Edit,
                singleLine = false
            )
        }
        Box(modifier = Modifier.padding(vertical = 10.dp)){
            MainButton(text = "Записать заметку"){
                viewModels.onEvent(AddNodeEvent.SaveNode)
                navController.navigate(Route.NOTE_SCREEN)
            }
        }

    }
}
