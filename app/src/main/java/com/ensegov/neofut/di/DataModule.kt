package com.ensegov.neofut.di

import android.content.Context
import androidx.room.Room
import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.data.remote.standings.StandingsApi
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import com.ensegov.neofut.data.repository.CompetitionDetailRepositoryImpl
import com.ensegov.neofut.data.repository.CompetitionsRepository
import com.ensegov.neofut.data.repository.CompetitionsRepositoryImpl
import io.ktor.client.engine.android.*
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {

    // DataSources
    single { createDatabase(androidContext()) }

    factory { Android.create() }
    single { CompetitionsApi(get(), logging = true) }
    single { StandingsApi(get(), logging = true) }

    // Repository
    factory { Dispatchers.IO }

    factoryOf(::CompetitionsRepositoryImpl) { bind<CompetitionsRepository>() }
    factoryOf(::CompetitionDetailRepositoryImpl) { bind<CompetitionDetailRepository>() }
}

private fun createDatabase(context: Context): NeoFutDatabase =
    Room.databaseBuilder(
        context,
        NeoFutDatabase::class.java,
        "neofut_database"
    )
        .build()