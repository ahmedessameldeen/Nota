package com.nota.core.database.di

import com.nota.core.database.NotaDatabase
import com.nota.core.database.driver.DatabaseDriverFactory
import com.nota.core.database.repository.NoteRepositoryImpl
import com.nota.core.domain.repository.NoteRepository
import org.koin.dsl.module

val databaseModule = module {
    single { get<DatabaseDriverFactory>().create() }
    single { NotaDatabase(get()) }
    single<NoteRepository> { NoteRepositoryImpl(get()) }
}
