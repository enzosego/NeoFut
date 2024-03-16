package com.ensegov.neofut.competition_detail.presentation.player_stats

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.common.presentation.model.updateFromNetwork
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopStatsViewModel(
    private val topStatsRepository: TopStatsRepository,
    private val type: String,
    private val id: Int,
    private val season: Int
) : ViewModel() {
    private val _playerStats: MutableStateFlow<UiState<List<PlayerStatsUiData>>> =
        MutableStateFlow(UiState.Success(emptyList()))
    val playerStats: StateFlow<UiState<List<PlayerStatsUiData>>> = _playerStats

    var isUpdatingFromNetwork by mutableStateOf(false)
        private set

    init {
        getTopStats()
    }

    private fun getTopStats() {
        viewModelScope.launch {
            val newValue = getFromDatabase()
            _playerStats.update {
                if (newValue.isNotEmpty())
                    UiState.Success(newValue)
                else
                    UiState.Loading
            }
            updateTopStats()
        }
    }

    private fun updateTopStats() = viewModelScope.launch {
        _playerStats.value.updateFromNetwork(
            canUpdate = { topStatsRepository.canUpdateTopStats(type, id, season) },
            update = { newValue -> _playerStats.update { newValue } },
            request = { fetchFromNetwork() },
            changeIsUpdatingValue = { isUpdatingFromNetwork = it },
        )
    }

    private suspend fun getFromDatabase() =
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