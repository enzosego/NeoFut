package com.ensegov.neofut.ui.competition

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
import com.ensegov.neofut.domain.model.Competition
import com.ensegov.neofut.domain.model.getLatestSeason
import com.ensegov.neofut.ui.competition.fixture.fixture
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun CupDetail(competition: Competition) {

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
        fixture(
            { currentFixture },
            canShowPrevious,
            canShowNext,
            viewModel::onClickPrevious,
            viewModel::onClickNext
        )
        groupTable { standings }
    }
}