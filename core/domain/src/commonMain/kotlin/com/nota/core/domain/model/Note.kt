package com.nota.core.domain.model

import kotlinx.datetime.Instant

data class Note(
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAt: Instant,
    val updatedAt: Instant
)
