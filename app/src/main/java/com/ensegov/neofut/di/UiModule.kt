package com.ensegov.neofut.di

import com.ensegov.neofut.competition_detail.presentation.fixture.FixtureViewModel
import com.ensegov.neofut.competition_detail.presentation.player_stats.TopStatsViewModel
import com.ensegov.neofut.competition_detail.presentation.standings.StandingsViewModel
import com.ensegov.neofut.home.presentation.HomeViewModel
import com.ensegov.neofut.match_detail.presentation.MatchDetailViewModel
import com.ensegov.neofut.match_detail.presentation.events.EventsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::HomeViewModel)

    viewModelOf(::FixtureViewModel)
    viewModelOf(::StandingsViewModel)
    viewModel(named(name = "goals")) { params ->
        TopStatsViewModel(get(), type = "goals", params.get(), params.get())
    }
    viewModel(named(name = "assists")) { params ->
        TopStatsViewModel(get(), type = "assists", params.get(), params.get())
    }

    viewModelOf(::MatchDetailViewModel)
    viewModelOf(::EventsViewModel)
}