package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
internal fun StandingsLoadingLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        repeat(12) {
            StandingsLoadingItem()
        }
    }
}

@Preview
@Composable
private fun StandingsLoadingLayoutPreview() {
    NeoFutTheme {
        StandingsLoadingLayout()
    }
}