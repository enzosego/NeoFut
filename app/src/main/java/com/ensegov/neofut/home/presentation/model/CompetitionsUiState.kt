package com.ensegov.neofut.home.presentation.model

import com.ensegov.neofut.competition_detail.presentation.model.Competition

sealed interface CompetitionsUiState {
    data class Success(val list: List<Competition>): CompetitionsUiState
    data object Loading: CompetitionsUiState
    data object Error: CompetitionsUiState
}