package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.ensegov.neofut.common.presentation.layout.LogoLayout

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
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(.1f)
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .weight(.7f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoLayout(
                logoUrl = position.teamLogo,
                modifier = Modifier
                    .height(35.dp)
                    .weight(.2f)
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
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(.1f)
                .padding(start = 8.dp)
        )
        Text(
            text = "${position.goalsDiff}",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(.1f)
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
            goalsDiff = -24,
            form = null,
            status = null,
            description = null
        )
    )
}