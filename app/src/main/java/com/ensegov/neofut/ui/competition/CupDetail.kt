package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.ui.competition.model.Competition
import com.ensegov.neofut.ui.competition.model.getLatestSeason
import org.koin.androidx.compose.koinViewModel

@Composable
fun CupDetail(competition: Competition) {

    val viewModel: CompetitionDetailViewModel = koinViewModel()

    val standings: List<List<TeamPosition>> by viewModel.standings.collectAsState()

    viewModel.getStandings(competition.id, competition.getLatestSeason())

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
        GroupTable(standings)
    }
}