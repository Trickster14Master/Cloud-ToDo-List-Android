package ru.example.cloudtodolistandroid.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.example.cloudtodolistandroid.data.repository.StockNoteRepositoryImpl
import ru.example.cloudtodolistandroid.domain.repository.StockNoteRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsStockNoteRepository(
        stockNoteRepositoryImpl:StockNoteRepositoryImpl
    ): StockNoteRepository
}