package com.ensegov.neofut.di

import com.ensegov.neofut.domain.use_case.home.GetCountryCompetitionsUseCase
import com.ensegov.neofut.domain.use_case.home.HomeUseCases
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    // Use Cases
    factoryOf(::HomeUseCases)
    factoryOf(::GetCountryCompetitionsUseCase)
}