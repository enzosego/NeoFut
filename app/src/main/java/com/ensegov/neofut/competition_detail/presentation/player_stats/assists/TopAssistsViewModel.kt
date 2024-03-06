package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.ui.common.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopAssistsViewModel(
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
        _playerStats.update { UiState.Loading }
        viewModelScope.launch {
            val newValue = topStatsRepository.getTopAssists(competitionId, competitionSeason)
            _playerStats.update {
                try {
                    UiState.Success(
                        newValue.ifEmpty {
                            topStatsRepository
                                .getTopAssistsFromNetwork(competitionId, competitionSeason)
                        }
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                    UiState.Error
                }
            }
        }
    }

    companion object {
        const val TAG = "TopAssistsViewModel"
    }
}