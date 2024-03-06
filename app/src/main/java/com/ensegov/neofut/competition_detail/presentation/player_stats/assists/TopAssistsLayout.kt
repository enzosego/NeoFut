package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiState
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun TopAssistsLayout(
    competitionId: Int,
    competitionSeason: Int
) {

    val viewModel: TopAssistsViewModel = koinViewModel(
        parameters = { parametersOf(competitionId, competitionSeason) }
    )
    val playerStats by viewModel.playerStats.collectAsStateWithLifecycle()

    when (playerStats) {
        is PlayerStatsUiState.Loading -> TopAssistsLoadingLayout()
        is PlayerStatsUiState.Success -> TopAssistsTable(
            { (playerStats as PlayerStatsUiState.Success).data }
        )
        is PlayerStatsUiState.Error -> TopAssistsErrorLayout()
    }
}