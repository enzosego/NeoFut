package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.standings.model.StandingsUiState
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
    val standings by viewModel.standings.collectAsStateWithLifecycle()

    when(standings) {
        is StandingsUiState.Loading -> StandingsLoadingLayout()
        is StandingsUiState.Success -> GroupTable {
            (standings as StandingsUiState.Success).data
        }
        is StandingsUiState.Error -> StandingsErrorLayout()
    }
}