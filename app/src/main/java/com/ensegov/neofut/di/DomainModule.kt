package com.ensegov.neofut.di

import com.ensegov.neofut.data.repository.detail.CompetitionDetailRepository
import com.ensegov.neofut.data.repository.detail.CompetitionDetailRepositoryImpl
import com.ensegov.neofut.data.repository.competitions.CompetitionsRepository
import com.ensegov.neofut.data.repository.competitions.CompetitionsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    // Repository
    factory { Dispatchers.IO }

    factoryOf(::CompetitionsRepositoryImpl) { bind<CompetitionsRepository>() }
    factoryOf(::CompetitionDetailRepositoryImpl) { bind<CompetitionDetailRepository>() }
}