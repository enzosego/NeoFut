package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
internal fun StandingsErrorLayout(
    modifier: Modifier = Modifier
) {
    Text(
        text = "An error has occurred when loading the standings",
        modifier = modifier
    )
}

@Preview
@Composable
private fun StandingsErrorLayoutPreview() {
    NeoFutTheme {
        StandingsErrorLayout()
    }
}