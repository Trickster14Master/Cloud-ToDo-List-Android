package ru.example.cloudtodolistandroid.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.example.cloudtodolistandroid.domain.models.fail.FileDto
import ru.example.cloudtodolistandroid.domain.models.grouptask.GroupTaskDto
import ru.example.cloudtodolistandroid.domain.models.grouptask.GroupTaskPostDto
import ru.example.cloudtodolistandroid.domain.models.note.NoteDto
import ru.example.cloudtodolistandroid.domain.models.note.NotePostDto
import ru.example.cloudtodolistandroid.domain.models.task.TaskDto
import ru.example.cloudtodolistandroid.domain.models.taskforgroup.TaskForGroupDto
import ru.example.cloudtodolistandroid.domain.models.taskforgroup.TaskForGroupPostDto
import ru.example.cloudtodolistandroid.domain.models.user.AuthUser
import ru.example.cloudtodolistandroid.domain.models.user.RegistrationUser
import ru.example.cloudtodolistandroid.domain.models.user.UserToken

interface StockAPI {
    //GET

    @GET("/NoteAPI/NoteAPI/")
    suspend fun getNote(@Query("search") userToken: String):List<NoteDto>

    @GET("FileAPI/FileAPI/")
    suspend fun getFile(@Query("search") userToken: String):Result<List<FileDto>>

    @GET("TaskAPI/TaskAPI/")
    suspend fun getTask(@Query("search") userToken: String):Result<List<TaskDto>>

    @GET("GroupTaskAPI/GroupTaskAPI/")
    suspend fun getGroupTask(@Query("search") userToken: String):Result<List<GroupTaskDto>>

    @GET("TaskForGroupAPI/TaskForGroupAPI/")
    suspend fun getTaskForGroup(@Query("search") userToken: String):Result<List<TaskForGroupDto>>

    //POST

    @POST("NoteAPI/NoteAPI/")
    suspend fun postNote(@Body notePost: NotePostDto):Result<NotePostDto>

    @POST("TaskForGroupAPI/TaskForGroupAPI/")
    suspend fun postTaskForGroup(@Body taskForGroupPost: TaskForGroupPostDto):Result<TaskForGroupPostDto>

    @POST("GroupTaskAPI/GroupTaskAPI/")
    suspend fun postGroupTask(@Body groupTaskPost: GroupTaskPostDto):Result<GroupTaskPostDto>

    @POST("ToDo/auth/user/")
    suspend fun registrationUser(@Body registrationUser: RegistrationUser):Result<RegistrationUser>

    @POST("auth/token/login/")
    suspend fun authUser(@Body authUser: AuthUser):Result<UserToken>

    // DELETE
    @DELETE("/NoteAPI/NoteAPI/{id}/")
    suspend fun deleteNode(
        @Path("id") id:Int
    ): Response<Unit>
}