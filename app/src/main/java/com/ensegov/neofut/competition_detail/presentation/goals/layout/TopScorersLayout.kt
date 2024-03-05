package com.ensegov.neofut.competition_detail.presentation.goals.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.goals.TopScorersViewModel
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorersUiState
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun TopScorersLayout(
    competitionId: Int,
    competitionSeason: Int
) {
    val viewModel: TopScorersViewModel = koinViewModel(
        parameters = { parametersOf(competitionId, competitionSeason) }
    )
    val topScorers by viewModel.topScorers.collectAsStateWithLifecycle()

    when (topScorers) {
        is TopScorersUiState.Loading -> TopScorersLoadingLayout()
        is TopScorersUiState.Success -> TopScorersTable(
            { (topScorers as TopScorersUiState.Success).data }
        )
        is TopScorersUiState.Error -> TopScorersErrorLayout()
    }
}