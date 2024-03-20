package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.R
import com.ensegov.neofut.competition_detail.presentation.common.animatedUpdatingHeader
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.presentation.standings.model.PositionUiData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun GroupTable(
    standings: () -> List<CompetitionGroup>,
    isUpdating: () -> Boolean,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        animatedUpdatingHeader(isUpdating)
        standings().forEach { group ->
            item {
                Text(
                    text = group.groupName,
                    color = Color.Blue,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                )
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.team_position),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.1f)
                    )
                    Text(
                        text = stringResource(R.string.team_name),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.7f)
                    )
                    Text(
                        text = stringResource(R.string.team_points),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.1f)
                    )
                    Text(
                        text = stringResource(R.string.goal_diff),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.1f)
                    )
                }
            }
            items(
                items = group.teamList,
                key = { it.id }
            ) { team ->
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
        GroupTable(
            { mockData },
            { true }
        )
    }
}