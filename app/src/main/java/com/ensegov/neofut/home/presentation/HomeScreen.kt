package com.ensegov.neofut.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ensegov.neofut.destinations.CompetitionDetailScreenDestination
import com.ensegov.neofut.common.presentation.model.UiState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {

    val viewModel: HomeViewModel = koinViewModel()

    val competitionUiState by viewModel.competitionList.collectAsState()

    when(competitionUiState) {
        is UiState.Loading -> CompetitionsLoadingLayout()
        is UiState.Success -> CompetitionsLayout(
            competitionList = (competitionUiState as UiState.Success).data,
            navigate = { competition ->
                navigator.navigate(CompetitionDetailScreenDestination(competition))
            }
        )
        is UiState.Error -> CompetitionsErrorLayout()
    }
}