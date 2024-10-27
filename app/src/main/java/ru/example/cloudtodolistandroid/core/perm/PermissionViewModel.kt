package ru.example.cloudtodolistandroid.core.perm
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
class PermissionViewModel:ViewModel() {
    // условная очередь в которую мы помещаем разрешения
    val visiblePermissionDialogQueue= mutableStateListOf<String>()

    // управляем очередью
    fun dismissDialog(){
        // удаляем последний элемент
        visiblePermissionDialogQueue.removeLast()
    }

    // функция которая определяет было ли дано разрешение
    fun onPermissionResult(
        // разрешение
        permission:String,
        // статус разрешения
        isGranted:Boolean
    ){
        if(!isGranted){
            visiblePermissionDialogQueue.add(0,permission)
        }
    }
}

















































































































