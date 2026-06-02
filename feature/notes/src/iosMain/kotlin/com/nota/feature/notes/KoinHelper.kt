package com.nota.feature.notes

import com.nota.core.database.di.databaseModule
import com.nota.core.database.driver.DatabaseDriverFactory
import com.nota.feature.notes.di.notesModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(
            module { single { DatabaseDriverFactory() } },
            databaseModule,
            notesModule
        )
    }
}
