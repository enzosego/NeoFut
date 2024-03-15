package com.ensegov.neofut.competition_detail.presentation.fixture

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepository
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.common.presentation.model.updateFromNetwork
import com.ensegov.neofut.competition_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import kotlinx.coroutines.delay
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
    private val id: Int,
    private val season: Int
) : ViewModel() {

    private val roundList: StateFlow<List<RoundName>> = fixtureRepository
        .getSeasonRounds(id, season)
        .onEach { list ->
            val currentRound = list.find { round -> round.current }
            if (list.isEmpty() || currentRound == null)
                return@onEach
            else {
                getRoundFixture(currentRound.name)
                currentRoundIndex.update { list.indexOf(currentRound) }
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    var currentFixture: UiState<List<MatchDay>> by mutableStateOf(UiState.Loading)

    var isUpdatingFromNetwork by mutableStateOf(false)
        private set

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
            if (fixtureRepository.canUpdateSeasonRounds(id, season))
                try {
                    fixtureRepository
                        .updateSeasonRounds(id, season)
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                }
        }
    }

    private fun getRoundFixture(round: String) {
        viewModelScope.launch {
            val fixture = fixtureRepository
                .getRoundFixture(id, season, round)
            if (fixture.isNotEmpty())
                currentFixture = UiState.Success(fixture)
            updateRoundFixture(round)
        }
    }

    private fun updateRoundFixture(round: String) {
        viewModelScope.launch {
            currentFixture.updateFromNetwork(
                canUpdate = { fixtureRepository.canUpdateRoundFixture(id, season, round) },
                update = { newValue -> currentFixture = newValue },
                changeIsUpdatingValue = { isUpdatingFromNetwork = it },
                request = { fixtureRepository.updateRoundFixture(id, season, round) },
                tag = TAG
            )
        }
    }

    fun onClickPrevious() {
        val newIndex = currentRoundIndex.value.minus(1)
        currentFixture = UiState.Loading
        getRoundFixture(roundList.value[newIndex].name)
        currentRoundIndex.update { newIndex }
    }

    fun onClickNext() {
        currentFixture = UiState.Loading
        val newIndex = currentRoundIndex.value.plus(1)
        getRoundFixture(roundList.value[newIndex].name)
        currentRoundIndex.update { newIndex }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5000L
        private const val TAG = "FixtureViewModel"
    }
}