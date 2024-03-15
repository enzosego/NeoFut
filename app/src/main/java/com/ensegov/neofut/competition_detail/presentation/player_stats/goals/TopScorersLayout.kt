package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.PlayerStatsLoadingLayout
import com.ensegov.neofut.common.presentation.model.UiState
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
    val playerStats by viewModel.playerStats.collectAsStateWithLifecycle()

    AnimatedContent(targetState = playerStats, label = "") { state ->
        when (state) {
            is UiState.Loading -> PlayerStatsLoadingLayout()
            is UiState.Success -> TopScorersTable(
                { state.data },
                { viewModel.isUpdatingFromNetwork }
            )
            is UiState.Error -> TopScorersErrorLayout()
        }
    }
}