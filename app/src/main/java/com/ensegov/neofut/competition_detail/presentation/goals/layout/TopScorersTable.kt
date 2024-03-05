package com.ensegov.neofut.competition_detail.presentation.goals.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.R
import com.ensegov.neofut.competition_detail.presentation.goals.model.PlayerUiData
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorerUiData
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun TopScorersTable(
    topScorerList: () -> List<TopScorerUiData>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        item {
            Text(
                text = stringResource(R.string.top_scorers),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(vertical = 8.dp, horizontal = 8.dp)
            ) {
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
        items(topScorerList()) { topScorer ->
            TopScorerRow(
                topScorer,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun TopScorersTablePreview() {
    val fakeList = List(20) {
        TopScorerUiData(
            player = PlayerUiData(
                name = "Player Number $it",
                firstName = "Player",
                lastName = "Number",
                photoUrl = ""
            ),
            position = it,
            totalGoals = 13,
            penaltyGoals = 2,
            teamName = "Team - $it",
            teamLogoUrl = ""
        )
    }
    NeoFutTheme {
        TopScorersTable({ fakeList })
    }
}