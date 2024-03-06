package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.standings.model.PositionUiData
import com.ensegov.neofut.ui.common.layout.LogoLayout

@Composable
fun TeamRow(position: PositionUiData) {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${position.position}",
            fontSize = 23.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(40.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .width(200.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoLayout(
                logoUrl = position.teamLogo,
                modifier = Modifier
                    .height(35.dp)
                    .weight(.25f)
            )
            Text(
                text = position.team,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(.75f)
            )
        }
        Text(
            text = "${position.points}",
            fontSize = 23.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(45.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = "${position.goalsDiff}",
            fontSize = 23.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(45.dp)
        )
    }
}

@Preview
@Composable
fun TeamRowPreview() {
    TeamRow(
        PositionUiData(
            team = "Independ. Rivadavia",
            teamLogo = "",
            position =  10,
            points = 53,
            goalsDiff = 24,
            form = null,
            status = null,
            description = null
        )
    )
}