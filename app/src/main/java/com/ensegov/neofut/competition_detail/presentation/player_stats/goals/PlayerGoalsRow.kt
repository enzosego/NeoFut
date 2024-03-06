package com.ensegov.neofut.competition_detail.presentation.player_stats.goals

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.player_stats.common.PlayerStatsRow
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun PlayerGoalsRow(
    topScorer: PlayerStatsUiData,
    modifier: Modifier = Modifier
) {
    PlayerStatsRow(
        leftWeight = .7f,
        playerStats = topScorer,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .weight(.3f)
        ) {
            Text(
                text = "${topScorer.totalGoals}",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier.weight(.15f)
            )
            Text(
                text = "${topScorer.penaltyGoals}",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier.weight(.15f)
            )
        }
    }
}

@Preview
@Composable
private fun TopScorerRowPreview() {
    NeoFutTheme {
        PlayerGoalsRow(
            PlayerStatsUiData(
                player = PlayerUiData(
                    name = "Franco Mastantuono",
                    firstName = "Franco",
                    lastName = "Mastantuono",
                    photoUrl = ""
                ),
                position = 4,
                totalGoals = 1,
                penaltyGoals = 0,
                assists = 2,
                teamName = "River Plate",
                teamLogoUrl = ""
            )
        )
    }
}