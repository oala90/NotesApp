package com.example.notesapp.di

import com.example.notesapp.data.local.source.NoteLocalDataSourceImpl
import com.example.notesapp.data.repository.NoteLocalDataSource
import com.example.notesapp.data.repository.NoteRepositoryImp
import com.example.notesapp.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun binNodeLocalDataSource(
        personLocalDataSourceImpl: NoteLocalDataSourceImpl
    ) : NoteLocalDataSource

    @Binds
    internal abstract fun bindNoteRepository(
        personRepositoryImpl: NoteRepositoryImp
    ) : NoteRepository
}