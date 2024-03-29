package com.ensegov.neofut.match_detail.presentation.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.match_detail.presentation.events.model.EventData
import com.ensegov.neofut.match_detail.presentation.events.model.EventType
import com.ensegov.neofut.match_detail.presentation.events.model.Locality
import com.ensegov.neofut.match_detail.presentation.events.types.CardEvent
import com.ensegov.neofut.match_detail.presentation.events.types.GoalEvent
import com.ensegov.neofut.match_detail.presentation.events.types.SubEvent
import com.ensegov.neofut.match_detail.presentation.events.types.VarEvent
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
        when (event.type) {
            is EventType.Goal -> GoalEvent(
                player = event.player,
                detail = event.type.detail)
            is EventType.Card -> CardEvent(
                player = event.player,
                detail = event.type.detail
            )
            is EventType.Sub -> SubEvent(
                out = event.player,
                into = event.playerTwo ?: ""
            )
            is EventType.Var -> VarEvent(event.type.detail)
        }
    }
}

@Preview
@Composable
private fun EventItemPreview() {
    NeoFutTheme {
        EventItem(
            EventData(
                locality = Locality.HOME,
                type = EventType.Card(detail = "Red Card"),
                player = "Agustin Ruberto",
                playerTwo = null
            )
        )
    }
}