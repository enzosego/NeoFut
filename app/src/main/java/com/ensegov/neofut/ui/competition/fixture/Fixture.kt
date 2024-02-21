package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

fun LazyListScope.Fixture(
    currentFixture: () -> List<MatchFixture>,
    coroutineScope: () -> CoroutineScope,
    scroll: (Int) -> Unit,
) {

    val scope = coroutineScope()

    item {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    scope.launch {
                        scroll(-1)
                    }
                }
            ) {
                Text(text = "Prev")
            }
            Button(
                onClick = {
                    scope.launch {
                        scroll(1)
                    }
                }
            ) {
                Text(text = "Next")
            }
        }
    }
    items(currentFixture()) { match ->
        MatchCard(match)
    }
}