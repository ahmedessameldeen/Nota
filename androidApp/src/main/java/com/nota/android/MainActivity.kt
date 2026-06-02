package com.nota.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import com.nota.core.ui.theme.NotaTheme
import com.nota.feature.notes.navigation.NotesNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotaTheme(darkTheme = isSystemInDarkTheme()) {
                NotesNavHost()
            }
        }
    }
}
