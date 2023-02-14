package com.ensegov.neofut.di

import com.ensegov.neofut.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {

    viewModelOf(::MainViewModel)
}