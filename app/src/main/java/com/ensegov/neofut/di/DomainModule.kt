package com.ensegov.neofut.di

import com.ensegov.neofut.domain.use_case.competition_detail.CompetitionDetailUseCases
import com.ensegov.neofut.domain.use_case.competition_detail.GetRoundFixtureUseCase
import com.ensegov.neofut.domain.use_case.competition_detail.GetSeasonFixtureUseCase
import com.ensegov.neofut.domain.use_case.competition_detail.GetStandingsUseCase
import com.ensegov.neofut.domain.use_case.home.GetCountryCompetitionsUseCase
import com.ensegov.neofut.domain.use_case.home.HomeUseCases
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    /**
     * Use Cases
     */
    // Home
    factoryOf(::HomeUseCases)
    factoryOf(::GetCountryCompetitionsUseCase)

    // Competition Detail
    factoryOf(::CompetitionDetailUseCases)
    factoryOf(::GetStandingsUseCase)
    factoryOf(::GetSeasonFixtureUseCase)
    factoryOf(::GetRoundFixtureUseCase)
}