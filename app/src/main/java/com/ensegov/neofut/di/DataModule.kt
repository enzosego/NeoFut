package com.ensegov.neofut.di

import android.content.Context
import androidx.room.Room
import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.home.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.match_detail.data.remote.fixture.FixtureApi
import com.ensegov.neofut.competition_detail.data.remote.top_stats.TopStatsApi
import com.ensegov.neofut.competition_detail.data.remote.standings.StandingsApi
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
    single { TopStatsApi(get(), logging = true) }
}

private fun createDatabase(context: Context): NeoFutDatabase =
    Room.databaseBuilder(
        context,
        NeoFutDatabase::class.java,
        name = "neofut_database"
    )
        .build()