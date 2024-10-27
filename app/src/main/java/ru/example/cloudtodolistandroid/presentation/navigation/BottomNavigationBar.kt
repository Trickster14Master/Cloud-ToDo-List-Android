package ru.example.cloudtodolistandroid.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.example.cloudtodolistandroid.ui.theme.Purple700
import ru.example.cloudtodolistandroid.ui.theme.light_grey
import ru.example.cloudtodolistandroid.ui.theme.main_red
import ru.example.cloudtodolistandroid.ui.theme.primary
import ru.example.cloudtodolistandroid.ui.theme.primary_container
import ru.example.cloudtodolistandroid.ui.theme.secondary
import ru.example.cloudtodolistandroid.ui.theme.secondary_container

@Composable
fun BottomNavigationBar(
    item:List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick:(BottomNavItem)->Unit
) {
    val backStackEntry=navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier=modifier,
        backgroundColor = secondary_container,
        elevation = 5.dp
    ) {
        item.forEach{item->
            val selected = item.routing == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected =selected,
                onClick = { onItemClick(item) },
                selectedContentColor = primary,
                unselectedContentColor = secondary,
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Icon(
                            modifier= Modifier.size(20.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            )
                        if(selected){
                            Text(text = item.name, color = Purple700, fontSize = 14.sp)
                        }
                    }
                }
            )
        }
    }
}