package com.ensegov.neofut.di

import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepository
import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepositoryImpl
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepository
import com.ensegov.neofut.competition_detail.data.repository.standings.StandingsRepositoryImpl
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepositoryImpl
import com.ensegov.neofut.home.data.repository.CompetitionsRepository
import com.ensegov.neofut.home.data.repository.CompetitionsRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    // Repository
    factory { Dispatchers.IO }

    factoryOf(::CompetitionsRepositoryImpl) { bind<CompetitionsRepository>() }
    factoryOf(::FixtureRepositoryImpl) { bind<FixtureRepository>() }
    factoryOf(::StandingsRepositoryImpl) { bind<StandingsRepository>() }
    factoryOf(::TopStatsRepositoryImpl) { bind<TopStatsRepository>() }
    factoryOf(::TopStatsRepositoryImpl) { bind<TopStatsRepository>() }
}