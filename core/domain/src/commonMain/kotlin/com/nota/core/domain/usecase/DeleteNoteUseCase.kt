package com.nota.core.domain.usecase

import com.nota.core.domain.repository.NoteRepository
import com.nota.core.domain.util.Resource

class DeleteNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Long): Resource<Unit> {
        return try {
            repository.delete(id)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error("Failed to delete note", e)
        }
    }
}
