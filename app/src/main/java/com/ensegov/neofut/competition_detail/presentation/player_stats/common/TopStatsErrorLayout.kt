package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun TopStatsErrorLayout(
    type: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "There was an error while trying to retrieve the Top $type table",
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
private fun TopScorersErrorLayoutPreview() {
    NeoFutTheme {
        TopStatsErrorLayout(type = "Goals")
    }
}