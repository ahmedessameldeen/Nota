package com.nota.android

import android.app.Application
import com.nota.core.database.di.databaseModule
import com.nota.core.database.driver.DatabaseDriverFactory
import com.nota.feature.notes.di.notesModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NotaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotaApplication)
            modules(
                module { single { DatabaseDriverFactory(get()) } },
                databaseModule,
                notesModule
            )
        }
    }
}
