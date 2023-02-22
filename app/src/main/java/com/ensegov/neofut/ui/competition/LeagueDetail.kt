package com.ensegov.neofut.ui.competition

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
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.ui.competition.fixture.Fixture
import com.ensegov.neofut.ui.competition.model.Competition
import com.ensegov.neofut.ui.competition.model.getLatestSeason
import org.koin.androidx.compose.koinViewModel

@Composable
fun LeagueDetail(competition: Competition) {

    val viewModel: CompetitionDetailViewModel = koinViewModel()

    viewModel.getSeasonFixture(competition.id, competition.getLatestSeason())
    viewModel.getStandings(competition.id, competition.getLatestSeason())

    val standings: List<List<TeamPosition>> by viewModel.standings.collectAsStateWithLifecycle()
    val roundList by viewModel.roundList.collectAsStateWithLifecycle()

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
        Fixture { roundList }
        GroupTable { standings }
    }
}