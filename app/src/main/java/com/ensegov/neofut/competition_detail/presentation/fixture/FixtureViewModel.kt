package com.ensegov.neofut.competition_detail.presentation.fixture

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepository
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FixtureViewModel(
    private val fixtureRepository: FixtureRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val roundList: StateFlow<List<String>> = fixtureRepository
        .getSeasonFixture(competitionId, competitionSeason)
        .onEach { if (it.isNotEmpty()) getRoundFixture(it[0]) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    var currentFixture: UiState<List<MatchDay>> by mutableStateOf(UiState.Loading)

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

    init {
        updateSeasonFixture()
    }

    private fun updateSeasonFixture() {
        viewModelScope.launch {
            if (fixtureRepository.canUpdateSeasonRounds(competitionId, competitionSeason))
                try {
                    fixtureRepository
                        .updateSeasonFixture(competitionId, competitionSeason)
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                }
        }
    }

    private fun getRoundFixture(round: String) {
        viewModelScope.launch {
            val fixture = fixtureRepository
                .getRoundFixture(competitionId, competitionSeason, round)
            if (fixture.isNotEmpty())
                currentFixture = UiState.Success(fixture)
            updateRoundFixture(round)
        }
    }

    private fun updateRoundFixture(round: String) {
        viewModelScope.launch {
            currentFixture =
                if (fixtureRepository
                    .canUpdateRoundFixture(competitionId, competitionSeason, round)
                )
                    try {
                        UiState.Success(
                            fixtureRepository
                                .updateRoundFixture(competitionId, competitionSeason, round)
                        )
                    } catch (e: Exception) {
                        Log.d(TAG, "${e.message}")
                        UiState.Error
                    }
                else if (currentFixture is UiState.Loading)
                    UiState.Success(emptyList())
                else
                    currentFixture
        }
    }

    fun onClickPrevious() {
        val newIndex = currentRoundIndex.value.minus(1)
        currentFixture = UiState.Loading
        getRoundFixture(roundList.value[newIndex])
        currentRoundIndex.update { newIndex }
    }

    fun onClickNext() {
        currentFixture = UiState.Loading
        val newIndex = currentRoundIndex.value.plus(1)
        getRoundFixture(roundList.value[newIndex])
        currentRoundIndex.update { newIndex }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5000L
        private const val TAG = "FixtureViewModel"
    }
}