package com.nota.feature.notes.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.*
import com.nota.feature.notes.detail.NoteDetailScreen
import com.nota.feature.notes.list.NoteListScreen

@Composable
fun NotesNavHost() {
    var screen by remember { mutableStateOf<NotesScreen>(NotesScreen.List) }

    AnimatedContent(
        targetState = screen,
        transitionSpec = {
            if (targetState is NotesScreen.Detail) {
                slideInHorizontally { it } + fadeIn() togetherWith slideOutHorizontally { -it / 3 } + fadeOut()
            } else {
                slideInHorizontally { -it / 3 } + fadeIn() togetherWith slideOutHorizontally { it } + fadeOut()
            }
        }
    ) { current ->
        when (current) {
            is NotesScreen.List -> NoteListScreen(
                onNavigateToDetail = { id -> screen = NotesScreen.Detail(id) }
            )
            is NotesScreen.Detail -> NoteDetailScreen(
                noteId = current.noteId,
                onBack = { screen = NotesScreen.List }
            )
        }
    }
}

private sealed class NotesScreen {
    data object List : NotesScreen()
    data class Detail(val noteId: Long?) : NotesScreen()
}
