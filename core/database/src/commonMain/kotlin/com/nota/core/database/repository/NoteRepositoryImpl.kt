package com.nota.core.database.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.nota.core.database.NotaDatabase
import com.nota.core.database.NoteEntity
import com.nota.core.domain.model.Note
import com.nota.core.domain.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class NoteRepositoryImpl(private val db: NotaDatabase) : NoteRepository {

    private val queries get() = db.noteEntityQueries

    override fun observeAll(): Flow<List<Note>> =
        queries.selectAll().asFlow().mapToList(Dispatchers.IO).map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun getById(id: Long): Note? = withContext(Dispatchers.IO) {
        queries.selectById(id).executeAsOneOrNull()?.toDomain()
    }

    override suspend fun insert(title: String, content: String) = withContext(Dispatchers.IO) {
        val now = Clock.System.now().toEpochMilliseconds()
        queries.insert(title, content, now, now)
    }

    override suspend fun update(id: Long, title: String, content: String) = withContext(Dispatchers.IO) {
        val now = Clock.System.now().toEpochMilliseconds()
        queries.update(title, content, now, id)
    }

    override suspend fun delete(id: Long) = withContext(Dispatchers.IO) {
        queries.delete(id)
    }
}

private fun NoteEntity.toDomain() = Note(
    id = id,
    title = title,
    content = content,
    createdAt = Instant.fromEpochMilliseconds(created_at),
    updatedAt = Instant.fromEpochMilliseconds(updated_at)
)
