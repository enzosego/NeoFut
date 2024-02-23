package com.ensegov.neofut.ui.competition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.repository.detail.CompetitionDetailRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionDetailViewModel(
    private val competitionDetailRepository: CompetitionDetailRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val roundList: StateFlow<List<String>> = competitionDetailRepository
        .getSeasonFixture(competitionId, competitionSeason)
        .map { it?.roundList ?: emptyList() }
        .onEach {
            if (it.isEmpty())
                updateSeasonFixture()
            else
                getRoundFixture(it[0])
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    val currentFixture = MutableStateFlow(listOf<MatchFixture>())

    private val currentRoundIndex: MutableStateFlow<Int> = MutableStateFlow(0)

    val canShowPrevious: StateFlow<Boolean> = currentRoundIndex.map { it > 0 }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = true
        )

    val canShowNext: StateFlow<Boolean> = currentRoundIndex.map { it < roundList.value.lastIndex }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = true
        )

    val standings: StateFlow<List<List<TeamPosition>>> = competitionDetailRepository
        .getStandings(competitionId, competitionSeason)
        .map { it?.groupList ?: emptyList() }
        .onEach { if (it.isEmpty()) updateStandings() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue =emptyList()
        )

    private fun updateStandings() {
        viewModelScope.launch {
            competitionDetailRepository.updateStandings(competitionId, competitionSeason)
        }
    }

    private fun updateSeasonFixture() {
        viewModelScope.launch {
            competitionDetailRepository.updateSeasonFixture(competitionId, competitionSeason)
        }
    }

    private fun getRoundFixture(round: String) {
        val fixture = competitionDetailRepository
            .getRoundFixture(competitionId, competitionSeason, round)
        viewModelScope.launch {
            currentFixture.update {
                fixture.first()?.matchList
                    ?: competitionDetailRepository
                        .updateRoundFixture(competitionId, competitionSeason, round)
            }
        }
    }

    fun onClickPrevious() {
        val newIndex = currentRoundIndex.value.minus(1)
        getRoundFixture(roundList.value[newIndex])
        currentRoundIndex.update { newIndex }
    }

    fun onClickNext() {
        val newIndex = currentRoundIndex.value.plus(1)
        getRoundFixture(roundList.value[newIndex])
        currentRoundIndex.update { newIndex }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5000L
        private const val TAG = "CompetitionDetailViewModel"
    }
}