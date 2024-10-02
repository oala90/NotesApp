package com.example.notesapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.data.dao.NoteDao
import com.example.notesapp.data.model.db.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDB : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}