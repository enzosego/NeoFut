package com.ensegov.neofut.di

import com.ensegov.neofut.competition_detail.presentation.CompetitionDetailViewModel
import com.ensegov.neofut.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::HomeViewModel)
    viewModelOf(::CompetitionDetailViewModel)
}