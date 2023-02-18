package com.ensegov.neofut.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.local.model.competition.info.asUiModel
import com.ensegov.neofut.data.repository.CompetitionsRepository
import com.ensegov.neofut.domain.use_case.home.HomeUseCases
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    useCases: HomeUseCases
) : ViewModel() {

    val competitionList: StateFlow<List<Competition>> = useCases.getCountryCompetitions()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
}