package com.nota.feature.notes.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nota.core.domain.repository.NoteRepository
import com.nota.core.domain.usecase.SaveNoteUseCase
import com.nota.core.domain.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NoteDetailViewModel(
    private val repository: NoteRepository,
    private val saveNote: SaveNoteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NoteDetailContract.State())
    val state: StateFlow<NoteDetailContract.State> = _state.asStateFlow()

    private val _effect = Channel<NoteDetailContract.Effect>(Channel.BUFFERED)
    val effect: Flow<NoteDetailContract.Effect> = _effect.receiveAsFlow()

    fun onIntent(intent: NoteDetailContract.Intent) {
        when (intent) {
            is NoteDetailContract.Intent.LoadNote -> loadNote(intent.id)
            is NoteDetailContract.Intent.TitleChanged -> _state.update { it.copy(title = intent.title) }
            is NoteDetailContract.Intent.ContentChanged -> _state.update { it.copy(content = intent.content) }
            is NoteDetailContract.Intent.SaveClicked -> save()
        }
    }

    private fun loadNote(id: Long) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, noteId = id) }
            val note = repository.getById(id)
            if (note != null) {
                _state.update { it.copy(title = note.title, content = note.content, isLoading = false) }
            } else {
                _state.update { it.copy(isLoading = false) }
                _effect.send(NoteDetailContract.Effect.ShowError("Note not found"))
            }
        }
    }

    private fun save() {
        viewModelScope.launch {
            _state.update { it.copy(isSaving = true) }
            val s = _state.value
            when (val result = saveNote(s.noteId, s.title, s.content)) {
                is Resource.Success -> _effect.send(NoteDetailContract.Effect.NoteSaved)
                is Resource.Error -> _effect.send(NoteDetailContract.Effect.ShowError(result.message))
            }
            _state.update { it.copy(isSaving = false) }
        }
    }
}
