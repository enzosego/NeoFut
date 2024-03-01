package com.ensegov.neofut.competition_detail.presentation.fixture.model

sealed interface FixtureUiState {
    data class Success(val data: List<MatchUiShort>): FixtureUiState
    data object Loading: FixtureUiState
    data object Error: FixtureUiState
}