package com.ensegov.neofut.competition_detail.presentation.standings

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
    val standings by viewModel.standings.collectAsStateWithLifecycle()

    when(standings) {
        is UiState.Loading -> StandingsLoadingLayout()
        is UiState.Success -> GroupTable(
            { (standings as UiState.Success).data }
        )
        is UiState.Error -> StandingsErrorLayout()
    }
}