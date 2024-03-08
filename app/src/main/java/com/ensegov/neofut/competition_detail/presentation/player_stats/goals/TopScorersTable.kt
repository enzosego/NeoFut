package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.R
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.NoStatsAvailableText
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.StatsColumnNames
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.StatsTitle
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.getStatsList
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun TopScorersTable(
    players: () -> List<PlayerStatsUiData>,
    modifier: Modifier = Modifier
) {
    when(players().size) {
        0 -> NoStatsAvailableText(stringRes = R.string.no_goals_list)
        else -> LazyColumn(
            modifier = modifier.fillMaxWidth()
        ) {
            item {
                StatsTitle(text = stringResource(R.string.top_scorers))
            }
            item {
                StatsColumnNames {
                    Text(
                        text = stringResource(R.string.player_name),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.7f)
                    )
                    Text(
                        text = stringResource(R.string.goals),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.15f)
                    )
                    Text(
                        text = stringResource(R.string.penalty_goals),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(.15f)
                    )
                }
            }
            items(players()) { topScorer ->
                PlayerGoalsRow(
                    topScorer,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

}

@Preview
@Composable
private fun TopScorersTablePreview() {
    NeoFutTheme {
        TopScorersTable({ getStatsList() })
    }
}