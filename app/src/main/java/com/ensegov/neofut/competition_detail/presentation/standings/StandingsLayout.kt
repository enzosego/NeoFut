package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.common.presentation.model.UiState
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun StandingsLayout(
    competitionId: Int,
    competitionSeason: Int
) {
    val viewModel: StandingsViewModel = koinViewModel(
        parameters = { parametersOf(competitionId, competitionSeason) }
    )
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val standings by viewModel.standings.collectAsStateWithLifecycle()

    AnimatedContent(targetState = uiState, label = "") { state ->
        when (state) {
            is UiState.Loading -> StandingsLoadingLayout()
            is UiState.Success -> GroupTable(
                { standings },
                { viewModel.isUpdating }
            )
            is UiState.Error -> StandingsErrorLayout()
        }
    }
}