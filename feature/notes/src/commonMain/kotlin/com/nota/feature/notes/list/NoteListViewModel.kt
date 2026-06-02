package com.nota.feature.notes.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nota.core.domain.usecase.DeleteNoteUseCase
import com.nota.core.domain.usecase.GetNotesUseCase
import com.nota.core.domain.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NoteListViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNote: DeleteNoteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NoteListContract.State())
    val state: StateFlow<NoteListContract.State> = _state.asStateFlow()

    private val _effect = Channel<NoteListContract.Effect>(Channel.BUFFERED)
    val effect: Flow<NoteListContract.Effect> = _effect.receiveAsFlow()

    init {
        onIntent(NoteListContract.Intent.LoadNotes)
    }

    fun onIntent(intent: NoteListContract.Intent) {
        when (intent) {
            is NoteListContract.Intent.LoadNotes -> observeNotes()
            is NoteListContract.Intent.DeleteNote -> delete(intent.id)
            is NoteListContract.Intent.NoteClicked -> {
                viewModelScope.launch {
                    _effect.send(NoteListContract.Effect.NavigateToDetail(intent.id))
                }
            }
            is NoteListContract.Intent.AddNoteClicked -> {
                viewModelScope.launch {
                    _effect.send(NoteListContract.Effect.NavigateToDetail(null))
                }
            }
        }
    }

    private fun observeNotes() {
        getNotes().onEach { notes ->
            _state.update { it.copy(notes = notes, isLoading = false, error = null) }
        }.catch { e ->
            _state.update { it.copy(isLoading = false, error = e.message) }
        }.launchIn(viewModelScope)
    }

    private fun delete(id: Long) {
        viewModelScope.launch {
            when (val result = deleteNote(id)) {
                is Resource.Success -> {} // list updates via Flow
                is Resource.Error -> _effect.send(NoteListContract.Effect.ShowError(result.message))
            }
        }
    }
}
