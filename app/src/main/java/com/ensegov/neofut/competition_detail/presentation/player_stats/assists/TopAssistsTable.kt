package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.R
import com.ensegov.neofut.competition_detail.presentation.common.animatedUpdatingHeader
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.PlayerStatsRow
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.StatsColumnNames
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.StatsTitle
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.getStatsList
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun TopAssistsTable(
    playerStats: () -> List<PlayerStatsUiData>,
    isUpdating: () -> Boolean,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        animatedUpdatingHeader(isUpdating)
        item {
            StatsTitle(text = stringResource(R.string.top_assists))
        }
        item {
            StatsColumnNames {
                Text(
                    text = stringResource(R.string.player_name),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(.85f)
                )
                Text(
                    text = stringResource(R.string.assists),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(.15f)
                )
            }
        }
        items(playerStats()) { stats ->
            PlayerStatsRow(
                leftWeight = .85f, playerStats = stats
            ) {
                Text(
                    text = "${stats.assists}",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxHeight()
                        .weight(.15f)
                        .wrapContentHeight()
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopAssistsTablePreview() {
    NeoFutTheme {
        TopAssistsTable(
            { getStatsList() },
            { true }
        )
    }
}