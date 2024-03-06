package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiState
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopScorersViewModel(
    private val topStatsRepository: TopStatsRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val _playerStats: MutableStateFlow<PlayerStatsUiState> =
        MutableStateFlow(PlayerStatsUiState.Loading)
    val playerStats: StateFlow<PlayerStatsUiState> = _playerStats

    init {
        getTopScorers()
    }

    private fun getTopScorers() {
        _playerStats.update { PlayerStatsUiState.Loading }
        viewModelScope.launch {
            val newValue = topStatsRepository.getTopScorers(competitionId, competitionSeason)
            _playerStats.update {
                try {
                    PlayerStatsUiState.Success(
                        newValue.ifEmpty {
                            topStatsRepository
                                .getTopScorersFromNetwork(competitionId, competitionSeason)
                        }
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                    PlayerStatsUiState.Error
                }
            }
        }
    }
    companion object {
        const val TAG = "TopScorersViewModel"
    }
}