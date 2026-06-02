package com.nota.feature.notes.di

import com.nota.core.domain.usecase.DeleteNoteUseCase
import com.nota.core.domain.usecase.GetNotesUseCase
import com.nota.core.domain.usecase.SaveNoteUseCase
import com.nota.feature.notes.detail.NoteDetailViewModel
import com.nota.feature.notes.list.NoteListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val notesModule = module {
    factory { GetNotesUseCase(get()) }
    factory { SaveNoteUseCase(get()) }
    factory { DeleteNoteUseCase(get()) }
    viewModel { NoteListViewModel(get(), get()) }
    viewModel { NoteDetailViewModel(get(), get()) }
}
