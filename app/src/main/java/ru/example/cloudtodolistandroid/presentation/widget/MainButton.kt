package ru.example.cloudtodolistandroid.presentation.widget

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import ru.example.cloudtodolistandroid.ui.theme.main_red
import ru.example.cloudtodolistandroid.ui.theme.secondary

@Composable
fun MainButton(text:String, onClick:()->Unit){
    Button(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(secondary)
    ) {
        Text(modifier = Modifier.padding(vertical = 7.dp),text = text, color = Color.White)
    }
}