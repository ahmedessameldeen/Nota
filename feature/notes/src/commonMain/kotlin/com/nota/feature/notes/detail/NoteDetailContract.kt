package com.nota.feature.notes.detail

object NoteDetailContract {

    data class State(
        val noteId: Long? = null,
        val title: String = "",
        val content: String = "",
        val isLoading: Boolean = false,
        val isSaving: Boolean = false
    )

    sealed class Intent {
        data class LoadNote(val id: Long) : Intent()
        data class TitleChanged(val title: String) : Intent()
        data class ContentChanged(val content: String) : Intent()
        data object SaveClicked : Intent()
    }

    sealed class Effect {
        data object NoteSaved : Effect()
        data class ShowError(val message: String) : Effect()
    }
}
