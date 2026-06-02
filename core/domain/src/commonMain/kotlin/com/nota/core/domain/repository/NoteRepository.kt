package com.nota.core.domain.repository

import com.nota.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun observeAll(): Flow<List<Note>>
    suspend fun getById(id: Long): Note?
    suspend fun insert(title: String, content: String)
    suspend fun update(id: Long, title: String, content: String)
    suspend fun delete(id: Long)
}
