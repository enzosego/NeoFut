package com.ensegov.neofut.di

import android.content.Context
import androidx.room.Room
import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.remote.competition.CompetitionsApiImpl
import com.ensegov.neofut.data.repository.CompetitionsRepository
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {

    // DataSources
    single { createDatabase(androidContext()) }
    single { CompetitionsApiImpl.create() }

    // Repository
    factory { Dispatchers.IO }

    singleOf(::CompetitionsRepository)
}

private fun createDatabase(context: Context): NeoFutDatabase =
    Room.databaseBuilder(
        context,
        NeoFutDatabase::class.java,
        "neofut_database"
    )
        .build()