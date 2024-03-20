package com.ensegov.neofut.competition_detail.presentation.player_stats

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopStatsViewModel(
    private val topStatsRepository: TopStatsRepository,
    private val type: String,
    private val id: Int,
    private val season: Int
) : ViewModel() {

    val playerStats: StateFlow<List<PlayerStatsUiData>> = getFromDatabase()
        .onEach {
            if (it.isEmpty())
                _uiState.update { UiState.Loading }
            updateTopStats()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    private val _uiState = MutableStateFlow<UiState<Boolean>>(UiState.Success(data = false))
    val uiState = _uiState.asStateFlow()

    var isUpdating by mutableStateOf(false)
        private set

    private fun updateTopStats() = viewModelScope.launch {
        if (topStatsRepository.canUpdateTopStats(type, id, season)) {
            isUpdating = true
            _uiState.update {state ->
                try {
                    fetchFromNetwork()
                    UiState.Success(data = false)
                } catch (e: Exception) {
                    if (state is UiState.Loading)
                        UiState.Error("")
                    else
                        state
                }
            }
        }
    }

    private fun getFromDatabase() =
        if (type == "goals")
            topStatsRepository.getTopScorers(id, season)
        else
            topStatsRepository.getTopAssists(id, season)

    private suspend fun fetchFromNetwork() =
        if (type == "goals")
            topStatsRepository.updateTopScorers(id, season)
        else
            topStatsRepository.updateTopAssists(id, season)
}