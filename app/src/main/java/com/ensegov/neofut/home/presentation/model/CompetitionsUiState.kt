package com.ensegov.neofut.home.presentation.model

sealed interface CompetitionsUiState {
    data class Success(val list: List<Competition>): CompetitionsUiState
    data object Loading: CompetitionsUiState
    data object Error: CompetitionsUiState
}