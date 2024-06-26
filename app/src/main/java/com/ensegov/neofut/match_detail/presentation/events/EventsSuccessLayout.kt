package com.ensegov.neofut.match_detail.presentation.events

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.match_detail.presentation.events.model.EventData
import com.ensegov.neofut.match_detail.presentation.events.model.EventMoment
import com.ensegov.neofut.match_detail.presentation.events.model.EventType
import com.ensegov.neofut.match_detail.presentation.events.model.Locality
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun EventsSuccessLayout(
    moments: () -> List<EventMoment>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        moments().forEach { moment ->
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalDivider(
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "${moment.time}'",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    HorizontalDivider(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            items(
                items = moment.events,
            ) { event ->
                EventItem(event)
            }
        }
    }
}

@Preview
@Composable
private fun EventsSuccessLayoutPreview() {
    val fakeDatasource = (1..11).map {
        EventMoment(
            time = (1..90).random(),
            events = List(size = (1..7).random()) {
                EventData(
                    locality = Locality.entries.random(),
                    type = listOf(
                        EventType.Goal(listOf("Normal Goal", "Own Goal").random()),
                        EventType.Card(listOf("Yellow Card", "Red Card").random()),
                        EventType.Sub(""),
                        EventType.Var(listOf("Goal Cancelled", "Penalty Confirmed").random()),
                    ).random(),
                    player = "Player#${(1..22).random()}",
                    playerTwo = "Player#${(23..46).random()}"
                )
            }
        )
    }.sortedByDescending { it.time }
    NeoFutTheme {
        EventsSuccessLayout(
            { fakeDatasource }
        )
    }
}