package com.ensegov.neofut.competition_detail.presentation.fixture

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.presentation.fixture.model.FixtureUiState
import com.ensegov.neofut.competition_detail.repository.CompetitionDetailRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FixtureViewModel(
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

    private fun updateSeasonFixture() {
        viewModelScope.launch {
            try {
                competitionDetailRepository.updateSeasonFixture(competitionId, competitionSeason)
            } catch (e: Exception) {
                Log.d(TAG, "${e.message}")
            }
        }
    }

    private fun getRoundFixture(round: String) {
        viewModelScope.launch {
            val fixture = competitionDetailRepository
                .getRoundFixture(competitionId, competitionSeason, round)
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
        currentFixture.update { FixtureUiState.Loading }
        getRoundFixture(roundList.value[newIndex])
        currentRoundIndex.update { newIndex }
    }

    fun onClickNext() {
        val newIndex = currentRoundIndex.value.plus(1)
        currentFixture.update { FixtureUiState.Loading }
        getRoundFixture(roundList.value[newIndex])
        currentRoundIndex.update { newIndex }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5000L
        private const val TAG = "FixtureViewModel"
    }
}