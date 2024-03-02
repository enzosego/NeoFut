package com.ensegov.neofut.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ensegov.neofut.destinations.CompetitionScreenDestination
import com.ensegov.neofut.home.presentation.model.CompetitionsUiState
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
        is CompetitionsUiState.Loading -> CompetitionsLoadingLayout()
        is CompetitionsUiState.Success -> CompetitionsLayout(
            competitionList = (competitionUiState as CompetitionsUiState.Success).list,
            navigate = { competition ->
                navigator.navigate(CompetitionScreenDestination(competition))
            }
        )
        is CompetitionsUiState.Error -> CompetitionsErrorLayout()
    }
}