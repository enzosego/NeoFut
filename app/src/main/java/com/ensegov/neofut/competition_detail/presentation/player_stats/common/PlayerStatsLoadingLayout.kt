package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun PlayerStatsLoadingLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        repeat(20) {
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