package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.ensegov.neofut.data.local.model.fixture.SimpleMatchFixture

fun LazyListScope.fixture(
    currentFixture: () -> List<SimpleMatchFixture>,
    canShowPrevious: () -> Boolean,
    canShowNext:  () -> Boolean,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
) {

    item {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { onClickPrevious() },
                enabled = canShowPrevious()
            ) {
                Text(text = "Prev")
            }
            Button(
                onClick = { onClickNext() },
                enabled = canShowNext()
            ) {
                Text(text = "Next")
            }
        }
    }
    items(currentFixture()) { match ->
        MatchCard(match)
    }
}