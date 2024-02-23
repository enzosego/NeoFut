package com.ensegov.neofut.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.ui.competition.model.Competition
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {

    val viewModel: HomeViewModel = koinViewModel()

    viewModel.getCompetitions()

    val competitionList: List<Competition> by viewModel.competitionList.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = "Available Competitions:",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 25.dp)
        )
        LazyVerticalGrid(
            GridCells.Fixed(count = 2),
            content = {
                items(competitionList.size) { i ->
                    CompetitionLogo(competitionList[i], navigator)
                }
            },
            modifier = Modifier.padding(top = 50.dp)
        )
    }
}