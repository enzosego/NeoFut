package com.ensegov.neofut.competition_detail.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.fixture.fixtureErrorLayout
import com.ensegov.neofut.competition_detail.presentation.fixture.fixtureLayout
import com.ensegov.neofut.competition_detail.presentation.fixture.fixtureLoadingLayout
import com.ensegov.neofut.competition_detail.presentation.fixture.model.FixtureUiState
import com.ensegov.neofut.competition_detail.presentation.model.Competition
import com.ensegov.neofut.competition_detail.presentation.model.getLatestSeason
import com.ensegov.neofut.competition_detail.presentation.standings.groupTable
import com.ensegov.neofut.competition_detail.presentation.standings.model.StandingsUiState
import com.ensegov.neofut.competition_detail.presentation.standings.standingsErrorLayout
import com.ensegov.neofut.competition_detail.presentation.standings.standingsLoadingLayout
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Destination
@Composable
fun CompetitionDetailScreen(competition: Competition) {

    val viewModel: CompetitionDetailViewModel = koinViewModel(
        parameters = { parametersOf(competition.id, competition.getLatestSeason()) }
    )

    val standings by viewModel.standings.collectAsStateWithLifecycle()
    val currentFixture by viewModel.currentFixture.collectAsStateWithLifecycle()
    val canShowPrevious by viewModel.canShowPrevious.collectAsStateWithLifecycle()
    val canShowNext by viewModel.canShowNext.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = competition.name,
                color = Color.Blue,
                fontSize = 30.sp
            )
        }
        when(currentFixture) {
            is FixtureUiState.Loading -> fixtureLoadingLayout()
            is FixtureUiState.Success -> fixtureLayout(
                { (currentFixture as FixtureUiState.Success).data },
                { canShowPrevious },
                { canShowNext },
                viewModel::onClickPrevious,
                viewModel::onClickNext
            )
            is FixtureUiState.Error -> fixtureErrorLayout()
        }
        when(standings) {
            is StandingsUiState.Loading -> standingsLoadingLayout()
            is StandingsUiState.Success -> groupTable {
                (standings as StandingsUiState.Success).data
            }
            is StandingsUiState.Error -> standingsErrorLayout()
        }
    }
}