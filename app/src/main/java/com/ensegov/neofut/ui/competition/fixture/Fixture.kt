package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Fixture(roundList: () -> List<String>) {

    val listState = rememberLazyListState()

    val scope = rememberCoroutineScope()

    val navigateList: (Int) -> Int = { it + listState.firstVisibleItemIndex }

    fun canScrollForward(): Boolean =
        listState.firstVisibleItemIndex < listState.layoutInfo.totalItemsCount - 1

    fun canScrollBack(): Boolean = listState.firstVisibleItemIndex > 0

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(navigateList(-1))
                    }
                },
                enabled = canScrollBack()
            ) {
                Text(text = "Prev")
            }
            Button(
                onClick = {
                    scope.launch {
                        listState.animateScrollToItem(navigateList(1))
                    }
                },
                enabled = canScrollForward()
            ) {
                Text(text = "Next")
            }
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            userScrollEnabled = false,
            state = listState
        ) {
            items(roundList()) { round ->
                RoundFixture(
                    modifier = Modifier
                        .padding(end = 400.dp),
                    round
                )
            }
        }
    }
}