package com.example.notesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.entity.NoteEntity
import com.example.notesapp.domain.usecases.note.AddNoteUseCase
import com.example.notesapp.domain.usecases.note.GetListNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getListNoteUseCase: GetListNoteUseCase,
    private val addNoteNoteUseCase: AddNoteUseCase,
) : ViewModel() {
    private val _noteList = MutableStateFlow<List<NoteEntity>>(emptyList())
    val noteList = _noteList.asStateFlow()

    val content = MutableStateFlow("")
//    val content = _content.asStateFlow()

    fun getAllNotes() = viewModelScope.launch {
        getListNoteUseCase().fold(
            {
                _noteList.value =it
            },
            {
                println("Error Load $it")
            }
        )
    }

    fun addNote() = viewModelScope.launch {
        val noteObject = NoteEntity(
            content = content.value
        )

        addNoteNoteUseCase(noteObject).fold(
            {
                println("Succes")
            },
            {
                println("Error Add $it")
            }
        )
    }
}