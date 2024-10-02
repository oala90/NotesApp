package com.example.notesapp.data.local.source

import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.model.db.Note
import com.example.notesapp.data.repository.NoteLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteLocalDataSourceImpl @Inject constructor(
    private val dao: NoteDao
): NoteLocalDataSource {
    override suspend fun getNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun insert(note: Note) {
        return dao.insert(note)
    }
}