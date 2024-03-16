package com.ensegov.neofut.competition_detail.presentation.fixture.match_day

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import com.ensegov.neofut.competition_detail.presentation.fixture.model.generateFakeMatch
import com.ensegov.neofut.ui.theme.NeoFutTheme

fun LazyListScope.matchDayLayout(
    matchDay: MatchDay,
    onClick: (Int) -> Unit
) {
    item {
        Text(
            text = matchDay.date,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
    }
    items(
        items = matchDay.matchList,
        key = { it.data.id }
    ) { match ->
        MatchCard(
            match = match,
            modifier = Modifier.clickable { onClick(match.data.id) }
        )
    }
}

@Preview
@Composable
private fun MatchDayLayoutPreview() {
    NeoFutTheme {
        LazyColumn {
            matchDayLayout(
                MatchDay(
                    date = "Saturday, March 9th",
                    matchList = List(5) {
                        generateFakeMatch(index = it, count = 5)
                    }
                )
            ) {}
        }
    }
}