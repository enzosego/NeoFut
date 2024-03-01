package com.ensegov.neofut.competition_detail.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.presentation.fixture.model.FixtureUiState
import com.ensegov.neofut.competition_detail.repository.CompetitionDetailRepository
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CompetitionDetailViewModel(
    private val competitionDetailRepository: CompetitionDetailRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val roundList: StateFlow<List<String>> = competitionDetailRepository
        .getSeasonFixture(competitionId, competitionSeason)
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

    val currentFixture: MutableStateFlow<FixtureUiState> =
        MutableStateFlow(FixtureUiState.Loading)

    private val currentRoundIndex: MutableStateFlow<Int> = MutableStateFlow(0)

    val canShowPrevious: StateFlow<Boolean> = currentRoundIndex.map { it > 0 }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = false
        )

    val canShowNext: StateFlow<Boolean> = currentRoundIndex.combine(roundList) { index, list ->
        index < list.lastIndex
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = true
        )

    val standings: StateFlow<List<CompetitionGroup>> = competitionDetailRepository
        .getStandings(competitionId, competitionSeason)
        .onEach {
            if (it.isEmpty()) updateStandings()
            else Log.d(TAG, "$it")
        }
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
        currentFixture.update { FixtureUiState.Loading }
        val fixture = competitionDetailRepository
            .getRoundFixture(competitionId, competitionSeason, round)
        viewModelScope.launch {
            currentFixture.update {
                try {
                    FixtureUiState.Success(
                        fixture.first().ifEmpty {
                            competitionDetailRepository
                                .updateRoundFixture(competitionId, competitionSeason, round)
                        }
                    )
                } catch (e: Exception) {
                    FixtureUiState.Error
                }
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