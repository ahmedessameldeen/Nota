package com.nota.feature.notes

import androidx.compose.ui.window.ComposeUIViewController
import com.nota.core.ui.theme.NotaTheme
import com.nota.feature.notes.navigation.NotesNavHost

fun MainViewController() = ComposeUIViewController {
    NotaTheme {
        NotesNavHost()
    }
}
