package com.ensegov.neofut.competition_detail.presentation.player_stats.assists

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.R
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.StatsColumnNames
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.StatsTitle
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.getStatsList
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun TopAssistsTable(
    playerStats: () -> List<PlayerStatsUiData>,
    modifier: Modifier = Modifier
) {
    when(playerStats().size) {
        0 -> Text(
            text = stringResource(R.string.no_assists_list),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = modifier.fillMaxWidth()
        )
        else -> LazyColumn(
            modifier = modifier.fillMaxWidth()
        ) {
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
                PlayerAssistsRow(
                    playerStats = stats,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview
@Composable
private fun TopAssistsTablePreview() {
    NeoFutTheme {
        TopAssistsTable({ getStatsList() })
    }
}