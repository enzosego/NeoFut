package com.ensegov.neofut.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.home.presentation.model.Competition
import com.ensegov.neofut.home.data.remote.competition.dto.Country
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun CompetitionsLayout(
    competitionList: List<Competition>,
    navigate: (Competition) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Available Competitions:",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 25.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            modifier = Modifier.padding(top = 50.dp),
        ) {
            items(competitionList) { competition ->
                CompetitionCard(
                    competition = competition,
                    onClickAction = { navigate(competition) },
                    modifier = Modifier
                        .height(160.dp)
                        .padding(8.dp)
                )
            }
        }

    }
}

@Preview
@Composable
private fun CompetitionsLayoutPreview() {
    val mockDataset = List(10) { i ->
        Competition(
            id = i,
            name = "Competition #$i",
            type = "",
            logoUrl = "",
            country = Country(name = "", code = null, flagUrl = ""),
            seasons = emptyList()
        )
    }
    NeoFutTheme {
        CompetitionsLayout(
            competitionList = mockDataset,
            navigate = {}
            )
    }
}