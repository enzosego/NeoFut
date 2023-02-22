package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.domain.use_case.competition_detail.CompetitionDetailUseCases
import kotlinx.coroutines.flow.*

class CompetitionDetailViewModel(
    private val useCases: CompetitionDetailUseCases
) : ViewModel() {

    lateinit var standings: StateFlow<List<List<TeamPosition>>>

    lateinit var roundList: StateFlow<List<String>>

    fun getStandings(id: Int, season: Int) {
        standings = useCases.getStandings(id, season)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    fun getSeasonFixture(id: Int, season: Int) {
        roundList = useCases.getSeasonFixture(id, season)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }
}