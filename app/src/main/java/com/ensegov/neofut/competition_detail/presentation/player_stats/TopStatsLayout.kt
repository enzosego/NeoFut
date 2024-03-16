package com.ensegov.neofut.competition_detail.presentation.player_stats

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.presentation.player_stats.assists.TopAssistsTable
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.PlayerStatsLoadingLayout
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.TopStatsErrorLayout
import com.ensegov.neofut.competition_detail.presentation.player_stats.goals.TopScorersTable
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

@Composable
fun TopStatsLayout(
    type: String,
    competitionId: Int,
    competitionSeason: Int
) {
    val viewModel: TopStatsViewModel = koinViewModel(
        parameters = { parametersOf(competitionId, competitionSeason) },
        qualifier = named(type)
    )
    val playerStats by viewModel.playerStats.collectAsStateWithLifecycle()

    AnimatedContent(targetState = playerStats, label = "") { state ->
        when (state) {
            is UiState.Loading -> PlayerStatsLoadingLayout()
            is UiState.Success ->
                AnimatedVisibility(visible = state.data.isNotEmpty()) {
                    if (type == "assists")
                        TopAssistsTable(
                            { state.data },
                            { viewModel.isUpdatingFromNetwork }
                        )
                    else
                        TopScorersTable(
                            players = { state.data },
                            isUpdating = { viewModel.isUpdatingFromNetwork }
                        )
                }
            is UiState.Error -> TopStatsErrorLayout(type)
        }
    }
}