package com.ensegov.neofut.di

import com.ensegov.neofut.data.remote.competition.CompetitionApiImpl
import com.ensegov.neofut.data.remote.team.TeamsApiImplementation
import com.ensegov.neofut.data.repository.CompetitionsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    // DataSources
    single { CompetitionApiImpl.create() }
    single { TeamsApiImplementation.create() }

    // Repository
    singleOf(::CompetitionsRepository)
}