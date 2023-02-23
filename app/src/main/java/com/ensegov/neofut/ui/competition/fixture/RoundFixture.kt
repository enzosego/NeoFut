package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.ui.competition.CompetitionDetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun Fixture(
    modifier: Modifier,
    round: String,
) {

    val viewModel: CompetitionDetailViewModel = koinViewModel()

    viewModel.getRoundFixture(round)

    val fixture by viewModel.currentFixture.collectAsStateWithLifecycle()

    LazyColumn(modifier) {
        items(fixture) { match ->
            MatchDetail(match)
        }
    }
}