package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.competition.dto.standings.Standings
import com.ensegov.neofut.data.remote.competition.dto.standings.TeamPosition
import com.ensegov.neofut.data.repository.CompetitionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CompetitionViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    private val _standings = MutableStateFlow<List<Standings>>(emptyList())
    val standings: StateFlow<List<Standings>> get() = _standings

    fun getStandings(competitionId: String) = viewModelScope.launch {
        val newStandings =
            competitionsRepository.getStandings(competitionId).standingsList
        _standings.emit(newStandings)
    }
}