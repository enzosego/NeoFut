package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.common.presentation.layout.shimmerEffect

@Composable
internal fun StandingsLoadingItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(.1f))
        Row(
            modifier = Modifier.weight(.7f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.weight(.05f))
            Box(
                modifier = Modifier
                    .height(35.dp)
                    .weight(.1f)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.weight(.05f))
            Box(
                modifier = Modifier
                    .height(20.dp)
                    .weight(.6f)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.weight(.1f))
        }
        Spacer(modifier = Modifier.weight(.2f))
    }
}

@Preview
@Composable
private fun FixtureLoadingItemPreview() {
    StandingsLoadingItem()
}