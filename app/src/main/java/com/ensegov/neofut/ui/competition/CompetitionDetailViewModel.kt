package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionDetailViewModel(
    private val competitionDetailRepository: CompetitionDetailRepository,
) : ViewModel() {

    val standings: StateFlow<List<List<TeamPosition>>> = competitionDetailRepository.currentStandings
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getStandings(id: Int, season: Int) = viewModelScope.launch {
        competitionDetailRepository.getStandings(id, season)
    }
}