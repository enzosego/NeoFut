package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.ui.competition.model.PositionUiData

@Composable
fun TeamRow(position: PositionUiData) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp)
    ) {
        Text(
            text = "${position.position}",
            fontSize = 23.sp,
            modifier = Modifier
                .width(30.dp),
        )
        Text(
            text = position.team,
            fontSize = 23.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = "${position.points}",
            fontSize = 23.sp,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
fun TeamRowPreview() {
    TeamRow(
        PositionUiData(
            team = "River Plate",
            teamLogo = "",
            position =  1,
            points = 53,
            goalsDiff = 24,
            form = null,
            status = null,
            description = null
        )
    )
}