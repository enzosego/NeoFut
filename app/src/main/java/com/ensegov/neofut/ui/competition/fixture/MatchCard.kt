package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ensegov.neofut.data.local.model.fixture.SimpleMatchFixture
import com.ensegov.neofut.ui.home.getImageModel

@Composable
fun MatchCard(match: SimpleMatchFixture) {

    val context = LocalContext.current
    val homeTeam = match.homeTeam
    val awayTeam = match.awayTeam

    Row(
        modifier = Modifier
            .height(100.dp)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        AsyncImage(
            model = getImageModel(homeTeam.logoUrl ?: "", context),
            contentDescription = null,
        )
        Text(
            text = homeTeam.name,
            fontSize = 20.sp
        )
        Text(text = "${match.data.homeScore ?: 0}")
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(2.dp)
                .background(color = Color.Green)
        )
        Text(text = "${match.data.awayScore ?: 0}")
        Text(
            text = awayTeam.name,
            fontSize = 20.sp
        )
        AsyncImage(
            model = getImageModel(awayTeam.logoUrl ?: "", context),
            contentDescription = null,
        )
    }
}