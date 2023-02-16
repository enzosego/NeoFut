package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.competition.dto.standings.Standings
import com.ensegov.neofut.data.repository.CompetitionsRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    val standings: StateFlow<List<Standings>> = competitionsRepository.currentStandings
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getStandings(id: String) = viewModelScope.launch {
        competitionsRepository.setStandings(id)
    }
}