package com.example.notesapp.data.mapper

import com.example.notesapp.data.model.db.Note
import com.example.notesapp.domain.entity.NoteEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun Flow<List<Note>>.toEntity(): Flow<List<NoteEntity>> {
    return this.map { notes ->
        notes.map { note ->
            NoteEntity(
                id = note.id,
                content = note.content
            )
        }
    }
}

fun NoteEntity.toDTO(): Note {
    return Note(
        id = id,
        content = content
    )
}