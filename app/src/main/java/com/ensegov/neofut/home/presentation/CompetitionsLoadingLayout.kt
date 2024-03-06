package com.ensegov.neofut.home.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.common.presentation.layout.shimmerEffect
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun CompetitionsLoadingLayout(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        modifier = modifier.padding(top = 75.dp)
    ) {
        items(List(10) {}) {
            Box(
                modifier = modifier
                    .height(160.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .shimmerEffect()
            )
        }
    }
}

@Preview
@Composable
private fun CompetitionsLoadingLayoutPreview() {
    NeoFutTheme {
        CompetitionsLoadingLayout()
    }
}