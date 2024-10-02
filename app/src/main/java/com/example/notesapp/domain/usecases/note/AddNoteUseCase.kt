package com.example.notesapp.domain.usecases.note

import com.example.notesapp.domain.entity.NoteEntity
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository,
    background: CoroutineDispatcher
):  UseCase<Unit, NoteEntity>(background){

    override suspend fun run(input: NoteEntity?) {
        requireNotNull(input){ "Note must not be null" }
        noteRepository.insert(input)
    }
}