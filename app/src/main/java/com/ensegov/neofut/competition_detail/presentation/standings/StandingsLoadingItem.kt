package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.competition_detail.presentation.utils.shimmerEffect

@Composable
internal fun StandingsLoadingItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(45.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(25.dp)
                .width(30.dp)
                .padding(start = 8.dp)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .height(25.dp)
                .width(200.dp)
                .padding(start = 12.dp)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .height(25.dp)
                .width(30.dp)
                .padding(start = 8.dp)
                .shimmerEffect()
        )
    }
}

@Preview
@Composable
private fun FixtureLoadingItemPreview() {
    StandingsLoadingItem()
}