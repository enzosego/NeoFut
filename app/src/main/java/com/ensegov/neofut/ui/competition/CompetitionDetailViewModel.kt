package com.ensegov.neofut.ui.competition

import android.util.Log
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

    private lateinit var roundList: StateFlow<List<String>>

    var currentFixture: StateFlow<List<MatchFixture>> = flow<List<MatchFixture>> {}
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val currentRound: MutableStateFlow<String> = MutableStateFlow("")

    init {
        currentRound.onEach {
            if (it.isEmpty())
                return@onEach
            viewModelScope.launch {
                getRoundFixture(it)
            }
        }
    }

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

    private fun getRoundFixture(round: String) {
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

    fun setCurrentRound(index: Int) = viewModelScope.launch {
        Log.d("CompetitionDetailViewModel", "Index: $index")
        currentRound.emit(
            value = roundList.value.getOrNull(index) ?: ""
        )
    }

    fun setValues(competition: Competition) {
        competitionId = competition.id
        competitionSeason = competition.getLatestSeason()
    }
}