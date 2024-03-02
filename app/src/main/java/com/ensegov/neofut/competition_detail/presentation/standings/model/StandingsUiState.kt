package com.ensegov.neofut.competition_detail.presentation.standings.model

sealed interface StandingsUiState {
    data class Success(val data: List<CompetitionGroup>): StandingsUiState
    data object Loading: StandingsUiState
    data object Error: StandingsUiState
}