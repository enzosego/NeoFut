package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.common.presentation.model.UiState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun FixtureLayout(
    competitionId: Int,
    competitionSeason: Int,
    navigator: DestinationsNavigator
) {

    val viewModel: FixtureViewModel = koinViewModel(
        parameters = { parametersOf(competitionId, competitionSeason) }
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val currentFixture by viewModel.currentFixture.collectAsStateWithLifecycle()
    val canShowPrevious by viewModel.canShowPrevious.collectAsStateWithLifecycle()
    val canShowNext by viewModel.canShowNext.collectAsStateWithLifecycle()

    AnimatedContent(targetState = uiState, label = "") { state ->
        when (state) {
            is UiState.Loading -> FixtureLoadingLayout()
            is UiState.Success ->
                AnimatedVisibility(visible = currentFixture.isNotEmpty()) {
                    FixtureSuccessLayout(
                        { currentFixture },
                        { canShowPrevious },
                        { canShowNext },
                        { viewModel.isUpdating },
                        viewModel::onClickPrevious,
                        viewModel::onClickNext,
                        navigator
                    )
                }
            is UiState.Error -> FixtureErrorLayout()
        }
    }
}