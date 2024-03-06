package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.PlayerStatsLoadingLayout
import com.ensegov.neofut.common.presentation.model.UiState
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
        is UiState.Loading -> PlayerStatsLoadingLayout()
        is UiState.Success -> TopAssistsTable(
            { (playerStats as UiState.Success).data }
        )
        is UiState.Error -> TopAssistsErrorLayout()
    }
}