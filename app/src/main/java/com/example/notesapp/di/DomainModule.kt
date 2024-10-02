package com.example.notesapp.di

import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.usecases.note.AddNoteUseCase
import com.example.notesapp.domain.usecases.note.GetListNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideGetListNoteUseCase(
        repository: NoteRepository,
        background: CoroutineDispatcher
    ) = GetListNoteUseCase(repository, background)

    @Singleton
    @Provides
    fun provideAddNoteUseCase(
        repository: NoteRepository,
        background: CoroutineDispatcher
    ) = AddNoteUseCase(repository, background)
}