package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.domain.use_case.competition_detail.CompetitionDetailUseCases
import com.ensegov.neofut.ui.competition.model.Competition
import com.ensegov.neofut.ui.competition.model.getLatestSeason
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionDetailViewModel(
    private val useCases: CompetitionDetailUseCases
) : ViewModel() {

    private var competitionId = 0
    private var competitionSeason = 0

    lateinit var standings: StateFlow<List<List<TeamPosition>>>

    lateinit var roundList: StateFlow<List<String>>

    lateinit var currentFixture: StateFlow<List<MatchFixture>>

    private var currentJob: Job? = null

    fun getStandings() {
        standings = useCases.getStandings(competitionId, competitionSeason)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    fun getSeasonFixture() {
        roundList = useCases.getSeasonFixture(competitionId, competitionSeason)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    fun getRoundFixture(round: String) {
        currentJob?.cancel()
        currentJob = viewModelScope.launch {
            currentFixture = useCases.getRoundFixture(competitionId, competitionSeason, round)
                .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
        }
    }

    fun setValues(competition: Competition) {
        competitionId = competition.id
        competitionSeason = competition.getLatestSeason()
    }
}