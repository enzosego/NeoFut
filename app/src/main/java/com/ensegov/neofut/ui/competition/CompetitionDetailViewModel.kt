package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.local.model.fixture.season.asDomainModel
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import com.ensegov.neofut.domain.model.Competition
import com.ensegov.neofut.domain.model.getLatestSeason
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionDetailViewModel(
    private val competitionDetailRepository: CompetitionDetailRepository
) : ViewModel() {

    private var competitionId = 0
    private var competitionSeason = 0

    lateinit var standings: StateFlow<List<List<TeamPosition>>>

    lateinit var roundList: StateFlow<List<String>>

    lateinit var currentFixture: StateFlow<List<MatchFixture>>

    fun getStandings() {
        val newValue = competitionDetailRepository.getStandings(competitionId, competitionSeason)
            .map { it?.groupList ?: emptyList() }
        viewModelScope.launch {
            if (newValue.first().isEmpty())
                competitionDetailRepository.updateStandings(competitionId, competitionSeason)
        }
        standings = newValue
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    fun getSeasonFixture() {
        val newValue = competitionDetailRepository.getSeasonFixture(competitionId, competitionSeason)
            .map { it?.asDomainModel() ?: emptyList() }
        viewModelScope.launch {
            if (newValue.first().isEmpty())
                competitionDetailRepository.updateSeasonFixture(competitionId, competitionSeason)
        }
        roundList = newValue
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    private var currentJob: Job? = null

    fun getRoundFixture(round: String) {
        val newValue =
            competitionDetailRepository.getRoundFixture(competitionId, competitionSeason, round)
                .map { it?.matchList ?: emptyList() }
        viewModelScope.launch {
            if (newValue.first().isEmpty()) {
                currentJob?.cancel()
                currentJob = viewModelScope.launch {
                    competitionDetailRepository.updateRoundFixture(
                        competitionId, competitionSeason, round
                    )
                }
            }
        }
        currentFixture = newValue
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    }

    fun setValues(competition: Competition) {
        competitionId = competition.id
        competitionSeason = competition.getLatestSeason()
    }
}