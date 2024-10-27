package ru.example.cloudtodolistandroid.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.example.cloudtodolistandroid.data.local.CloudToDoListDB
import ru.example.cloudtodolistandroid.data.local.CloudToDoListDao
import ru.example.cloudtodolistandroid.data.remote.StockAPI
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    private const val BASE_URL="http://192.168.0.103:8000"

    // функция которая будет выводить логи
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    // провайд который даст доступ к OkHttpClient
    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder()
            // передаём функцию для выведения логов
            .addInterceptor(httpLoggingInterceptor)
            .build()

    // провайд для Retrofit
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            // применяем конвертер для json
            .addConverterFactory(GsonConverterFactory.create())
            // используем клинет okHttpClient для запросов к api
            .client(okHttpClient)
            .build()

    // привязываем ранее написанные функции к retrofit клиенту
    @Singleton
    @Provides
    fun providesPostService(retrofit: Retrofit) = retrofit.create(StockAPI::class.java)

    @Provides
    @Singleton
    fun provideStockDataBase(app: Application): CloudToDoListDB {
        return Room.databaseBuilder(
            app,
            CloudToDoListDB::class.java,
            "cloudtodolistdb.db"
        ).build()
    }
}