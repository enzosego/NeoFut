package com.ensegov.neofut.di

import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import com.ensegov.neofut.domain.repository.CompetitionDetailRepositoryImpl
import com.ensegov.neofut.data.repository.CompetitionsRepository
import com.ensegov.neofut.domain.repository.CompetitionsRepositoryImpl
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