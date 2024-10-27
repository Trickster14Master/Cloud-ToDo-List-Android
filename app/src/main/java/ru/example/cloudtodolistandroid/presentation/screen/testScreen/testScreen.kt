package ru.example.cloudtodolistandroid.presentation.screen.testScreen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.example.cloudtodolistandroid.core.perm.PermissionViewModel

@Composable
fun testScreen (){
    val viewModel= viewModel<PermissionViewModel>()
    val dialogQueue = viewModel.visiblePermissionDialogQueue

    val filePermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(), // OpenDocument()
        onResult = {isGranted->
            viewModel.onPermissionResult(
                permission = Manifest.permission.CAMERA,
                isGranted = isGranted
            )
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Button(
            onClick = {
                filePermissionResultLauncher.launch(
                    Manifest.permission.CAMERA
                )
            }
        ) {
            Text(text = "Разрешение на чтение файлов")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
            }
        ) {
            Text(text = "Разрешение на запись файлов")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}