package com.example.notesapp.domain.repository

import com.example.notesapp.domain.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun getNotes(): Flow<List<NoteEntity>>
    suspend fun insert(note: NoteEntity)
}