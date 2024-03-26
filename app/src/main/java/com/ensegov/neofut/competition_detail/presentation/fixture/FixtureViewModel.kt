package com.ensegov.neofut.competition_detail.presentation.fixture

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepository
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.match_detail.data.local.fixture.RoundName
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flattenMerge
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
            else
                currentRoundIndex.update { list.indexOf(currentRound) }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    private val _uiState = MutableStateFlow<UiState<Boolean>>(UiState.Success(data = false))
    val uiState = _uiState.asStateFlow()

    var isUpdating by mutableStateOf(false)
        private set

    private val currentRoundIndex: MutableStateFlow<Int?> = MutableStateFlow(value = null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val currentFixture = roundList.combine(currentRoundIndex) { list, index ->
        if (list.isEmpty() || index == null)
            return@combine emptyFlow()
        val roundName = list[index].name
        val fixture = fixtureRepository.getRoundFixture(id, season, roundName)
        _uiState.update {
            if (fixture.first().isEmpty())
                UiState.Loading
            else
                UiState.Success(data = false)
        }
        updateRoundFixture(roundName)
        fixture
    }
        .flattenMerge()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptyList()
        )

    val canShowPrevious: StateFlow<Boolean> = currentRoundIndex.map { it != null && it > 0 }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = false
        )

    val canShowNext: StateFlow<Boolean> = currentRoundIndex.combine(roundList) { index, list ->
        index != null && index < list.lastIndex
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
            if (fixtureRepository.canUpdateSeasonRounds(id, season)) {
                isUpdating = true
                try {
                    fixtureRepository
                        .updateSeasonRounds(id, season)
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                }
                isUpdating = false
            }
        }
    }

    private fun updateRoundFixture(round: String) = viewModelScope.launch {
        if (fixtureRepository.canUpdateRoundFixture(id, season, round)) {
            isUpdating = true
            _uiState.update { state ->
                try {
                    fixtureRepository.updateRoundFixture(id, season, round)
                    UiState.Success(data = false)
                } catch (e: Exception) {
                    if (state is UiState.Loading)
                        UiState.Error(e.message ?: "")
                    else
                        state
                }
            }
            isUpdating = false
        }
    }

    fun onClickPrevious() = currentRoundIndex.update { currentRoundIndex.value?.minus(1) }

    fun onClickNext() = currentRoundIndex.update { currentRoundIndex.value?.plus(1) }

    companion object {
        private const val TIMEOUT_MILLIS = 5000L
        private const val TAG = "FixtureViewModel"
    }
}