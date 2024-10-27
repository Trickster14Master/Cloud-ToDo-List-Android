package ru.example.cloudtodolistandroid.presentation.navigation

import ru.example.cloudtodolistandroid.R

val ListItemBottomBar=listOf(
    BottomNavItem(name = "Записки", routing = "note_screen_route", icon = R.drawable.note),
    BottomNavItem(name = "Файлы", routing = "file_screen_route", icon = R.drawable.folder),
    BottomNavItem(name = "Группа задач", routing = "group_task_screen_route", icon = R.drawable.todolist),
    BottomNavItem(name = "Задачи", routing = "task_screen_route", icon = R.drawable.task),
)