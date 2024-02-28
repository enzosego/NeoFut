package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.ui.competition.model.MatchUiShort

@Composable
fun MatchCard(
    match: MatchUiShort,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .background(MaterialTheme.colorScheme.secondary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TeamLogo(
            url = match.homeTeam.logoUrl,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp)
        )
        Text(
            text = match.homeTeam.name,
            fontSize = 20.sp
        )
        Text(text = "${match.data.homeScore}")
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(2.dp)
                .background(color = Color.Green)
        )
        Text(text = "${match.data.awayScore}")
        Text(
            text = match.awayTeam.name,
            fontSize = 20.sp
        )
        TeamLogo(
            url = match.awayTeam.logoUrl,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp)
        )
    }
}