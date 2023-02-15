package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.competition.dto.standings.TeamPosition
import com.ensegov.neofut.data.repository.CompetitionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CompetitionViewModel(
    private val competitionsRepository: CompetitionsRepository
) : ViewModel() {

    private val _competitionName = MutableStateFlow("Premier League")
    val competitionName: StateFlow<String> get() = _competitionName

    private val _standings = MutableStateFlow<List<TeamPosition>>(emptyList())
    val standings: StateFlow<List<TeamPosition>> get() = _standings

    init {
        getStandings()
    }

    private fun getCompetitionName() = viewModelScope.launch {
        val competition = competitionsRepository.getCompetition()
        _competitionName.emit(competition.name)
    }

    private fun getStandings() = viewModelScope.launch {
        val newStandings = competitionsRepository.getStandings().standingsList[0].table
        _standings.emit(newStandings)
    }
}