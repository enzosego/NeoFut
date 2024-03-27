package com.ensegov.neofut.match_detail.presentation.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun EventItem(
    event: MatchEventData,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "'${event.elapsedTime}",
                fontSize = 22.sp
            )
            Text(
                text = event.type,
                fontSize = 22.sp
            )
        }
        Text(
            text = event.player,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
private fun EventItemPreview() {
    NeoFutTheme {
        EventItem(
            MatchEventData(
                matchId = 12312,
                teamId = 1,
                player = "Agustin Ruberto",
                playerTwo = null,
                elapsedTime = 42,
                type = "Goal",
                detail = "Normal Goal"
            )
        )
    }
}