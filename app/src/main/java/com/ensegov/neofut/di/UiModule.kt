package com.ensegov.neofut.di

import com.ensegov.neofut.competition_detail.presentation.fixture.FixtureViewModel
import com.ensegov.neofut.competition_detail.presentation.player_stats.assists.TopAssistsViewModel
import com.ensegov.neofut.competition_detail.presentation.player_stats.goals.TopScorersViewModel
import com.ensegov.neofut.competition_detail.presentation.standings.StandingsViewModel
import com.ensegov.neofut.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::HomeViewModel)
    viewModelOf(::FixtureViewModel)
    viewModelOf(::StandingsViewModel)
    viewModelOf(::TopScorersViewModel)
    viewModelOf(::TopAssistsViewModel)
}