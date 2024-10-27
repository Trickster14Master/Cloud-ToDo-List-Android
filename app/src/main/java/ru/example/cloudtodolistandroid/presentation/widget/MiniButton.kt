package ru.example.cloudtodolistandroid.presentation.widget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialogState
import ru.example.cloudtodolistandroid.ui.theme.main_red

@Composable
fun MiniButton(text:String, textHorizontal: Dp, action: MaterialDialogState){
    Button(
        modifier = Modifier
            .padding(horizontal = 10.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = {
            action.show()
        },
        colors = ButtonDefaults.buttonColors(main_red)
    ) {
        Text(modifier = Modifier.padding(vertical = 1.dp, horizontal = textHorizontal),text = text, color = Color.White)
    }
}