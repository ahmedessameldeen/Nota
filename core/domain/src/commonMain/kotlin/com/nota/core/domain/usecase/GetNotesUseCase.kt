package com.nota.core.domain.usecase

import com.nota.core.domain.model.Note
import com.nota.core.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(private val repository: NoteRepository) {
    operator fun invoke(): Flow<List<Note>> = repository.observeAll()
}
