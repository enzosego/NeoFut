package com.ensegov.neofut.competition_detail.presentation.goals.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.goals.model.PlayerUiData
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorerUiData
import com.ensegov.neofut.ui.common.LogoLayout
import com.ensegov.neofut.ui.common.PlayerPhotoLayout
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun TopScorerRow(
    topScorer: TopScorerUiData,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(65.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(.7f)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "${topScorer.position}",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier.width(30.dp)
            )
            PlayerPhotoLayout(
                topScorer.player.photoUrl,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = topScorer.player.name,
                )
                Row {
                    LogoLayout(
                        logoUrl = topScorer.teamLogoUrl,
                        modifier = Modifier.height(25.dp)
                    )
                    Text(
                        text = topScorer.teamName,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
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
        TopScorerRow(
            TopScorerUiData(
                player = PlayerUiData(
                    name = "Franco Mastantuono",
                    firstName = "Franco",
                    lastName = "Mastantuono",
                    photoUrl = ""
                ),
                position = 4,
                totalGoals = 1,
                penaltyGoals = 0,
                teamName = "River Plate",
                teamLogoUrl = ""
            )
        )
    }
}