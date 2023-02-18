package com.ensegov.neofut.di

import com.ensegov.neofut.ui.competition.CompetitionDetailViewModel
import com.ensegov.neofut.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::HomeViewModel)
    viewModelOf(::CompetitionDetailViewModel)
}