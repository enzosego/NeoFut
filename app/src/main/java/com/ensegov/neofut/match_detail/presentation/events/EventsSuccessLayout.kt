package com.ensegov.neofut.match_detail.presentation.events

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.match_detail.data.local.events.model.MatchEventData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun EventsSuccessLayout(
    events: () -> List<MatchEventData>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(
            items = events(),
            key = { "${it.player}-${it.elapsedTime}${it.detail}" }
        ) { event ->
            EventItem(event)
        }
    }
}

@Preview
@Composable
private fun EventsSuccessLayoutPreview() {
    val fakeDatasource = List(20) {
        MatchEventData(
            matchId = it,
            teamId = (1..2).random(),
            player = "Player #${(1..22).random()}",
            playerTwo = null,
            elapsedTime = (1..90).random(),
            type = "subst",
            detail = "Substitution $it"
        )
    }.sortedByDescending { it.elapsedTime }
    NeoFutTheme {
        EventsSuccessLayout(
            { fakeDatasource }
        )
    }
}