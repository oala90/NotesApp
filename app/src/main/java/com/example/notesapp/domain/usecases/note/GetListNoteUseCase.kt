package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.entity.NoteEntity
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class GetListNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
    background: CoroutineDispatcher
):  UseCase<List<NoteEntity>, Unit>(background){
    override suspend fun run(input: Unit?): List<NoteEntity> {
        return noteRepository.getNotes().firstOrNull() ?: emptyList()
    }
}