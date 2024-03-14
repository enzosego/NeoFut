package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.common.presentation.model.updateFromNetwork
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopScorersViewModel(
    private val topStatsRepository: TopStatsRepository,
    private val id: Int,
    private val season: Int
) : ViewModel() {

    private val _playerStats: MutableStateFlow<UiState<List<PlayerStatsUiData>>> =
        MutableStateFlow(UiState.Loading)
    val playerStats: StateFlow<UiState<List<PlayerStatsUiData>>> = _playerStats

    init {
        getTopScorers()
    }

    private fun getTopScorers() {
        viewModelScope.launch {
            val newValue = topStatsRepository.getTopScorers(id, season)
            if (newValue.isNotEmpty())
                _playerStats.update { UiState.Success(newValue) }
            updateTopScorers()
        }
    }

    private fun updateTopScorers() = viewModelScope.launch {
        _playerStats.value.updateFromNetwork(
            canUpdate = { topStatsRepository.canUpdateTopScorers(id, season) },
            update = { newValue -> _playerStats.update { newValue } },
            changeIsUpdatingValue = {  },
            request = { topStatsRepository.updateTopScorers(id, season) },
            tag = TAG
        )
    }

    companion object {
        const val TAG = "TopScorersViewModel"
    }
}