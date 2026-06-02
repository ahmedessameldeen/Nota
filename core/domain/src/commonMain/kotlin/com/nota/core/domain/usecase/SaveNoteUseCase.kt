package com.nota.core.domain.usecase

import com.nota.core.domain.repository.NoteRepository
import com.nota.core.domain.util.Resource

class SaveNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(id: Long?, title: String, content: String): Resource<Unit> {
        if (title.isBlank()) return Resource.Error("Title cannot be empty")
        return try {
            if (id == null) repository.insert(title, content)
            else repository.update(id, title, content)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error("Failed to save note", e)
        }
    }
}
