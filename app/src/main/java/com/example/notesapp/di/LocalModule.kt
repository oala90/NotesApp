package com.example.notesapp.di

import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.local.db.NoteDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun providePersonDao(appDatabase: NoteDB): NoteDao = appDatabase.noteDao()
}