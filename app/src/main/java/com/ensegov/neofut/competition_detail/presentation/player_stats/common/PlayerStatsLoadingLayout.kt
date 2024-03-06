package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun PlayerStatsLoadingLayout(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(count = 20) {
            StatsLoadingItem()
        }
    }
}

@Preview
@Composable
private fun StatsLoadingLayoutPreview() {
    NeoFutTheme {
        PlayerStatsLoadingLayout()
    }
}