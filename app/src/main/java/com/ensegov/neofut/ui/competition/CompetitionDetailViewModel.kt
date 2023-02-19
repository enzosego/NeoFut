package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.domain.use_case.competition_detail.CompetitionDetailUseCases
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionDetailViewModel(
    private val useCases: CompetitionDetailUseCases
) : ViewModel() {

    lateinit var standings: StateFlow<List<List<TeamPosition>>>

    fun getStandings(id: Int, season: Int) = viewModelScope.launch {
        standings = useCases.getStandings(id, season)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }
}