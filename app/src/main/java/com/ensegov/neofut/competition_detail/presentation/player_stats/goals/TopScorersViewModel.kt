package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.common.presentation.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopScorersViewModel(
    private val topStatsRepository: TopStatsRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val _playerStats: MutableStateFlow<UiState<List<PlayerStatsUiData>>> =
        MutableStateFlow(UiState.Loading)
    val playerStats: StateFlow<UiState<List<PlayerStatsUiData>>> = _playerStats

    init {
        getTopScorers()
    }

    private fun getTopScorers() {
        viewModelScope.launch {
            val newValue = topStatsRepository.getTopScorers(competitionId, competitionSeason)
            if (newValue.isNotEmpty())
                _playerStats.update { UiState.Success(newValue) }
            updateTopScorers()
        }
    }

    private fun updateTopScorers() = viewModelScope.launch {
        if (topStatsRepository.canUpdateTopScorers(competitionId, competitionSeason))
            try {
                _playerStats.update {
                    UiState.Success(
                        topStatsRepository
                            .updateTopScorers(competitionId, competitionSeason)
                    )
                }
            } catch (e: Exception) {
                _playerStats.update { UiState.Error }
                Log.d(TAG, "${e.message}")
            }
    }

    companion object {
        const val TAG = "TopScorersViewModel"
    }
}