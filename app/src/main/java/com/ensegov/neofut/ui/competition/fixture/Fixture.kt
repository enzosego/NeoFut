package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Fixture(roundList: () -> List<String>) {

    LazyRow(
        modifier = Modifier
            .padding(20.dp)
    ) {
        items(roundList()) { round ->
            RoundFixture(round)
        }
    }
}