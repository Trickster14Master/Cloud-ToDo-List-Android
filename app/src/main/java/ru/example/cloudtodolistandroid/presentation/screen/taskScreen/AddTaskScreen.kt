package ru.example.cloudtodolistandroid.presentation.screen.taskScreen
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import ru.example.cloudtodolistandroid.presentation.widget.MainButton
import ru.example.cloudtodolistandroid.presentation.widget.MainOutlinedTextField
import ru.example.cloudtodolistandroid.presentation.widget.MiniButton
import ru.example.cloudtodolistandroid.ui.theme.main_blue
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun AddTaskScreen() {
    var pickedData by remember {
        mutableStateOf(LocalDate.now())
    }
    var pickedTime by remember {
        mutableStateOf(LocalTime.now())
    }
    var nameTask by remember {
        mutableStateOf("")
    }
    var descriptionTask by remember {
        mutableStateOf("")
    }
    // форматируем дату
    val formattedData by remember {
        // так как нам нужно изменять изменяймый обьект используем derivedStateOf
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyyy")
                .format(pickedData)
        }
    }
    val formattedTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(pickedTime)
        }
    }

    // переменная которая будет отвечать за состояние виджета выбора даты
    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()


    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 40.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column() {
            MainOutlinedTextField(valueUser = nameTask, onNameChange = {nameTask=it}, HintUser = "Имя задачи", UserIcon = Icons.Filled.Edit, modifier = Modifier.fillMaxWidth())
            MainOutlinedTextField(valueUser = descriptionTask, onNameChange = {descriptionTask=it}, HintUser = "Описание", UserIcon = Icons.Filled.Menu, modifier = Modifier.fillMaxWidth())
        }


        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MiniButton("Дата", 5.5.dp, dateDialogState)
                Column(
                    modifier = Modifier.padding(start = 5.dp, top = 12.dp)
                ) {
                    Text(text = pickedData.toString(), color = Color.White)
                    Divider(color = main_blue, modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp))
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MiniButton("Время", 0.dp, timeDialogState)
                Column(
                    modifier = Modifier.padding(start = 5.dp, top = 12.dp)
                ) {
                    Text(text = pickedTime.toString(), color = Color.White)
                    Divider(color = main_blue, modifier = Modifier
                        .fillMaxWidth()
                        .width(1.dp))
                }
            }
        }
        MainButton(text = "Записать заметку"){ }


    }
}