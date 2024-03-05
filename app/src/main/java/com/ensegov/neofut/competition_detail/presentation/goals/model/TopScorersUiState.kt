package com.ensegov.neofut.competition_detail.presentation.goals.model

sealed interface TopScorersUiState {
    data class Success(val data: List<TopScorerUiData>): TopScorersUiState
    data object Loading: TopScorersUiState
    data object Error: TopScorersUiState
}