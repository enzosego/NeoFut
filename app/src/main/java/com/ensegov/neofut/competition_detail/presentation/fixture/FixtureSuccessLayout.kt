package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.competition_detail.presentation.common.animatedUpdatingHeader
import com.ensegov.neofut.competition_detail.presentation.fixture.match_day.matchDayLayout
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import com.ensegov.neofut.competition_detail.presentation.fixture.model.generateFakeMatch
import com.ensegov.neofut.destinations.MatchDetailScreenDestination
import com.ensegov.neofut.ui.theme.NeoFutTheme
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import java.time.LocalDateTime

@Composable
fun FixtureSuccessLayout(
    currentFixture: () -> List<MatchDay>,
    canShowPrevious: () -> Boolean,
    canShowNext: () -> Boolean,
    isUpdating: () -> Boolean,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        animatedUpdatingHeader(isUpdating)
        item {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = onClickPrevious,
                    enabled = canShowPrevious()
                ) {
                    Text(text = "Prev")
                }
                Button(
                    onClick = onClickNext,
                    enabled = canShowNext()
                ) {
                    Text(text = "Next")
                }
            }
        }
        currentFixture().forEach {
            matchDayLayout(it) { matchId ->
                navigator.navigate(MatchDetailScreenDestination(matchId))
            }
        }
    }
}

@Preview
@Composable
private fun FixtureSuccessLayoutPreview() {
    val fakeDataset = List(4) {
        MatchDay(
            date = LocalDateTime.now().plusDays(it.toLong()),
            matchList = List(it+1) { index ->
                generateFakeMatch(index, it)
            }
        )
    }
    NeoFutTheme {
        FixtureSuccessLayout(
            currentFixture = { fakeDataset },
            canShowPrevious = { true },
            canShowNext = { true },
            onClickPrevious = {  },
            isUpdating = { true },
            onClickNext = {  },
            navigator = EmptyDestinationsNavigator
            )
    }
}