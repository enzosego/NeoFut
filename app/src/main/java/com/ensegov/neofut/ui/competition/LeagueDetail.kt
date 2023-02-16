package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.standings.Standings
import org.koin.androidx.compose.koinViewModel

@Composable
fun LeagueDetail(competition: Competition) {

    val viewModel: CompetitionViewModel = koinViewModel()

    val standings: List<Standings> by viewModel.standings.collectAsState()

    viewModel.getStandings(competition.code)

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
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {
            items(standings.getOrNull(0)?.table?.size ?: 0) { i ->
                TeamRow(standings[0].table[i])
            }
        }
    }
}