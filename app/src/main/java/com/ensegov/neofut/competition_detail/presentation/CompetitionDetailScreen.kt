package com.ensegov.neofut.competition_detail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.competition_detail.presentation.fixture.FixtureLayout
import com.ensegov.neofut.competition_detail.presentation.model.ClickableTabState
import com.ensegov.neofut.competition_detail.presentation.model.Competition
import com.ensegov.neofut.competition_detail.presentation.model.getLatestSeason
import com.ensegov.neofut.competition_detail.presentation.standings.StandingsLayout
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Destination
@Composable
fun CompetitionDetailScreen(competition: Competition) {

    val viewModel: CompetitionDetailViewModel = koinViewModel(
        parameters = { parametersOf(competition.id, competition.getLatestSeason()) }
    )

    val tabState by viewModel.tabState.collectAsStateWithLifecycle()
    val standings by viewModel.standings.collectAsStateWithLifecycle()
    val currentFixture by viewModel.currentFixture.collectAsStateWithLifecycle()
    val canShowPrevious by viewModel.canShowPrevious.collectAsStateWithLifecycle()
    val canShowNext by viewModel.canShowNext.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = competition.name,
            color = Color.Blue,
            fontSize = 30.sp
        )
        when(tabState) {
            ClickableTabState.FIXTURE -> FixtureLayout(
                { currentFixture },
                { canShowPrevious },
                { canShowNext },
                viewModel::onClickPrevious,
                viewModel::onClickNext
            )
            ClickableTabState.STANDINGS -> StandingsLayout { standings }
        }
    }
}