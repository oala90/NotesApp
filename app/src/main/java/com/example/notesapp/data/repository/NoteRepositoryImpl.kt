package com.example.notesapp.data.repository

import com.example.notesapp.data.mapper.toDTO
import com.example.notesapp.data.mapper.toEntity
import com.example.notesapp.data.model.db.Note
import com.example.notesapp.domain.entity.NoteEntity
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImp @Inject constructor(
    private val noteLocalDataSource: NoteLocalDataSource
): NoteRepository {
    override suspend fun getNotes(): Flow<List<NoteEntity>> {
        return noteLocalDataSource.getNotes().toEntity()
    }

    override suspend fun insert(note: NoteEntity) {
        return noteLocalDataSource.insert(note.toDTO())
    }
}

interface NoteLocalDataSource {
    suspend fun getNotes(): Flow<List<Note>>
    suspend fun insert(note: Note)
}