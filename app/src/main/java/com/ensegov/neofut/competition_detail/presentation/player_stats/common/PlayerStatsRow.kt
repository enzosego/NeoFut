package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.common.presentation.layout.LogoLayout
import com.ensegov.neofut.common.presentation.layout.PlayerPhotoLayout

@Composable
fun PlayerStatsRow(
    leftWeight: Float,
    playerStats: PlayerStatsUiData,
    modifier: Modifier = Modifier,
    statsLayout: @Composable RowScope.() -> Unit
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
                .weight(leftWeight)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "${playerStats.position}",
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier.width(30.dp)
            )
            PlayerPhotoLayout(
                playerStats.player.photoUrl,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = playerStats.player.name,
                )
                Row {
                    LogoLayout(
                        logoUrl = playerStats.teamLogoUrl,
                        modifier = Modifier.height(25.dp)
                    )
                    Text(
                        text = playerStats.teamName,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        statsLayout()
    }
}