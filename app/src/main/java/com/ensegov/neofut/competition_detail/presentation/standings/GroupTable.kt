package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.presentation.standings.model.PositionUiData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
internal fun GroupTable(standings: () -> List<CompetitionGroup>) {

    LazyColumn {
        standings().forEach { group ->
            item {
                Text(
                    text = group.groupName,
                    color = Color.Blue,
                    fontSize = 30.sp
                )
            }
            items(group.teamList) { team ->
                TeamRow(team)
            }
        }
    }
}

@Preview
@Composable
private fun GroupTablePreview() {
    val mockData = List(4) { i ->
        CompetitionGroup(
            groupName = "Group #$i",
            teamList = List(4) {
                PositionUiData(
                    team = "team $i-$it",
                    teamLogo = "",
                    position = it,
                    points = it * i,
                    goalsDiff = it - i,
                    form = null,
                    status = null,
                    description = null
                )
            }
        )
    }
    NeoFutTheme {
        GroupTable { mockData }
    }
}