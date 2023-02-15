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
import com.ensegov.neofut.data.remote.competition.dto.standings.TeamPosition
import org.koin.androidx.compose.koinViewModel

@Composable
fun League(viewModel: CompetitionViewModel = koinViewModel()) {

    val leagueName: String by viewModel.competitionName.collectAsState()

    val teamList: List<TeamPosition> by viewModel.standings.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = leagueName,
            color = Color.Blue,
            fontSize = 30.sp
        )
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
        ) {
            items(teamList.size) { i ->
                TeamRow(teamList[i])
            }
        }
    }
}