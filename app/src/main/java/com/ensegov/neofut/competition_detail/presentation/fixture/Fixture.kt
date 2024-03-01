package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort

fun LazyListScope.fixture(
    currentFixture: () -> List<MatchUiShort>,
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