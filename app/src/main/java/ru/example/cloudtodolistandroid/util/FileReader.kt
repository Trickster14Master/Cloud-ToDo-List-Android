package ru.example.cloudtodolistandroid.util

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

class FileReader(
    private val context: Context,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun uriToFileInfo(contextUri: Uri):FileInfo{
        return withContext(ioDispatcher){
            var bytes = context.contentResolver.openInputStream(contextUri)?.use { inputStream ->
                inputStream.readBytes()
            } ?: byteArrayOf()

            val fileName = UUID.randomUUID().toString()

            val miniType = context.contentResolver.getType(contextUri) ?: ""

            FileInfo(
                name = fileName,
                miniType = miniType,
                bytes = bytes
            )
        }
    }
}

class FileInfo(
    val name:String,
    val miniType: String,
    val bytes:ByteArray
)