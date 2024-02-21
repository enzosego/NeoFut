package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.ui.competition.fixture.Fixture
import com.ensegov.neofut.domain.model.Competition
import org.koin.androidx.compose.koinViewModel

@Composable
fun CupDetail(competition: Competition) {

    val viewModel: CompetitionDetailViewModel = koinViewModel()

    viewModel.setValues(competition)
    viewModel.getSeasonFixture()
    viewModel.getStandings()

    val standings by viewModel.standings.collectAsStateWithLifecycle()

    val rememberScope = rememberCoroutineScope()

    val scroll: (Int) -> Unit = { index ->
        viewModel.setCurrentRound(index)
    }

    scroll(0)

    val currentFixture by viewModel.currentFixture.collectAsStateWithLifecycle()

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
        Fixture(
            { currentFixture },
            { rememberScope },
            scroll
        )
        GroupTable { standings }
    }
}