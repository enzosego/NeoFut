package com.ensegov.neofut.match_detail.presentation.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.match_detail.presentation.events.model.EventData
import com.ensegov.neofut.match_detail.presentation.events.model.EventType
import com.ensegov.neofut.match_detail.presentation.events.model.Locality
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun EventItem(
    event: EventData,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = when (event.locality) {
            Locality.HOME -> Alignment.Start
            Locality.AWAY -> Alignment.End
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "${event.type}",
            fontSize = 22.sp
        )
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
            EventData(
                locality = Locality.AWAY,
                type = EventType.Goal(detail = "Normal Goal"),
                player = "Agustin Ruberto",
                playerTwo = null
            )
        )
    }
}