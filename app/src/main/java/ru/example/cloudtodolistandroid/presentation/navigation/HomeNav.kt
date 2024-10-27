package ru.example.cloudtodolistandroid.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.example.cloudtodolistandroid.ui.theme.bac
import ru.example.cloudtodolistandroid.ui.theme.light_grey
import ru.example.cloudtodolistandroid.ui.theme.main_red

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeNav() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = main_red,
        backgroundColor = bac,

        bottomBar = {
            BottomNavigationBar(
                item =ListItemBottomBar,
                navController =navController,
                onItemClick ={
                    navController.navigate(it.routing)
                },
            )
        },

    ) {
        NavigationForHome(navController = navController)
    }
}