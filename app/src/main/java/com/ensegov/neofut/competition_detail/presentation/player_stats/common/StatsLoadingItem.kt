package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.ui.common.shimmerEffect
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun StatsLoadingItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(65.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .width(30.dp)
        )
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .clip(CircleShape)
                .shimmerEffect()
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .width(140.dp)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .height(16.dp)
                    .width(100.dp)
                    .shimmerEffect()
            )
        }
    }
}

@Preview
@Composable
private fun StatsLoadingItemPreview() {
    NeoFutTheme {
        StatsLoadingItem()
    }
}