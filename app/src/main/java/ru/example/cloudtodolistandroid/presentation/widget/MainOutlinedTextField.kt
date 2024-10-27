package ru.example.cloudtodolistandroid.presentation.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import ru.example.cloudtodolistandroid.ui.theme.faded_blue
import ru.example.cloudtodolistandroid.ui.theme.main_blue
import ru.example.cloudtodolistandroid.ui.theme.primary

@Composable
fun MainOutlinedTextField(valueUser:String, onNameChange:(String)->Unit, HintUser:String, UserIcon: ImageVector, modifier: Modifier, singleLine:Boolean=true){

    TextField(

        value = valueUser,
        onValueChange = onNameChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            unfocusedBorderColor = main_blue,
            focusedBorderColor = faded_blue,
            cursorColor = primary
        ),
        modifier= modifier,
        label = {
            Text(
                text = HintUser,
                color = faded_blue,
                fontSize = 10.sp
            )
        },
        leadingIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = UserIcon,
                    contentDescription = null,
                    tint = faded_blue
                )
            }
        },
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Ascii,
            imeAction = ImeAction.Go
        ),
    )
}