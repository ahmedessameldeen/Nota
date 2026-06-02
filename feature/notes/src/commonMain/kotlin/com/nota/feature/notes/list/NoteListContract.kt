package com.nota.feature.notes.list

import com.nota.core.domain.model.Note

object NoteListContract {

    data class State(
        val notes: List<Note> = emptyList(),
        val isLoading: Boolean = true,
        val error: String? = null
    )

    sealed class Intent {
        data object LoadNotes : Intent()
        data class DeleteNote(val id: Long) : Intent()
        data class NoteClicked(val id: Long) : Intent()
        data object AddNoteClicked : Intent()
    }

    sealed class Effect {
        data class NavigateToDetail(val noteId: Long?) : Effect()
        data class ShowError(val message: String) : Effect()
    }
}
