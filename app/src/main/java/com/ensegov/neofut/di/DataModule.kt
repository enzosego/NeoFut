package com.ensegov.neofut.di

import android.content.Context
import androidx.room.Room
import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.data.remote.fixture.FixtureApi
import com.ensegov.neofut.data.remote.standings.StandingsApi
import com.ensegov.neofut.data.remote.team.TeamsApi
import io.ktor.client.engine.android.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    // DataSources
    single { createDatabase(androidContext()) }

    factory { Android.create() }
    single { CompetitionsApi(get(), logging = true) }
    single { StandingsApi(get(), logging = true) }
    single { FixtureApi(get(), logging = true) }
    single { TeamsApi(get(), logging = true) }
}

private fun createDatabase(context: Context): NeoFutDatabase =
    Room.databaseBuilder(
        context,
        NeoFutDatabase::class.java,
        name = "neofut_database"
    )
        .build()