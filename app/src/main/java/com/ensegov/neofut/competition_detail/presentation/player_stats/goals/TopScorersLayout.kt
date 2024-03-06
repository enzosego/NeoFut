package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiState
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
    val topScorers by viewModel.playerStats.collectAsStateWithLifecycle()

    when (topScorers) {
        is PlayerStatsUiState.Loading -> TopScorersLoadingLayout()
        is PlayerStatsUiState.Success -> TopScorersTable(
            { (topScorers as PlayerStatsUiState.Success).data }
        )
        is PlayerStatsUiState.Error -> TopScorersErrorLayout()
    }
}