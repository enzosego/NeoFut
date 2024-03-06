package com.ensegov.neofut.competition_detail.presentation.player_stats.model

sealed interface PlayerStatsUiState {
    data class Success(val data: List<PlayerStatsUiData>): PlayerStatsUiState
    data object Loading: PlayerStatsUiState
    data object Error: PlayerStatsUiState
}