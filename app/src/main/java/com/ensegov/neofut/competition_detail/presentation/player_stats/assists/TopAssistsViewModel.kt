package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

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

class TopAssistsViewModel(
    private val topStatsRepository: TopStatsRepository,
    private val competitionId: Int,
    private val competitionSeason: Int
) : ViewModel() {

    private val _playerStats: MutableStateFlow<UiState<List<PlayerStatsUiData>>> =
        MutableStateFlow(UiState.Loading)
    val playerStats: StateFlow<UiState<List<PlayerStatsUiData>>> = _playerStats

    init {
        getTopAssists()
    }

    private fun getTopAssists() {
        _playerStats.update { UiState.Loading }
        viewModelScope.launch {
            val newValue = topStatsRepository.getTopAssists(competitionId, competitionSeason)
            if (newValue.isNotEmpty())
                _playerStats.update {
                    UiState.Success(
                        newValue
                    )
                }
            updateTopAssists()
        }
    }

    private fun updateTopAssists() = viewModelScope.launch {
        _playerStats.update {
            if (topStatsRepository.canUpdateTopAssists(competitionId, competitionSeason))
                try {
                    UiState.Success(
                        topStatsRepository
                            .updateTopAssists(competitionId, competitionSeason)
                    )
                } catch (e: Exception) {
                    Log.d(TAG, "${e.message}")
                    UiState.Error
                }
            else if (_playerStats.value is UiState.Loading)
                UiState.Success(emptyList())
            else
                _playerStats.value
        }
    }

    companion object {
        const val TAG = "TopAssistsViewModel"
    }
}