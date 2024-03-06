package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.PlayerStatsRow
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.getFakePlayerStats
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun PlayerAssistsRow(
    playerStats: PlayerStatsUiData,
    modifier: Modifier = Modifier
) {
    PlayerStatsRow(
        leftWeight = .85f,
        playerStats = playerStats
    ) {
        Text(
            text = "${playerStats.assists}",
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxHeight()
                .weight(.15f)
                .wrapContentHeight()
        )
    }
}

@Preview
@Composable
private fun PlayerAssistsRowPreview() {
    NeoFutTheme {
        PlayerAssistsRow(getFakePlayerStats())
    }
}