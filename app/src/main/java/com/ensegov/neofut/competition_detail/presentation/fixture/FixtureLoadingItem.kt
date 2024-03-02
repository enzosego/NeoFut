package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.Arrangement
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
internal fun FixtureLoadingItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .height(20.dp)
                .width(120.dp)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .height(20.dp)
                .width(120.dp)
                .shimmerEffect()
        )
        Box(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
                .shimmerEffect()
        )
    }
}

@Preview
@Composable
private fun LoadingListItemPreview() {
    FixtureLoadingItem()
}