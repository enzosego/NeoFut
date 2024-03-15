package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.common.presentation.model.UiState
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
internal fun FixtureLayout(
    competitionId: Int,
    competitionSeason: Int,
) {

    val viewModel: FixtureViewModel = koinViewModel(
        parameters = { parametersOf(competitionId, competitionSeason) }
    )
    val currentFixture = viewModel.currentFixture
    val canShowPrevious by viewModel.canShowPrevious.collectAsStateWithLifecycle()
    val canShowNext by viewModel.canShowNext.collectAsStateWithLifecycle()

    AnimatedContent(targetState = currentFixture, label = "") { state ->
        when (state) {
            is UiState.Loading -> FixtureLoadingLayout()
            is UiState.Success -> FixtureSuccessLayout(
                { state.data },
                { canShowPrevious },
                { canShowNext },
                { viewModel.isUpdatingFromNetwork },
                viewModel::onClickPrevious,
                viewModel::onClickNext
            )
            is UiState.Error -> FixtureErrorLayout()
        }
    }
}