package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

internal fun LazyListScope.standingsErrorLayout(
    modifier: Modifier = Modifier
) {
    item {
        Text("An error has occurred when loading the standings")
    }
}

@Preview
@Composable
private fun StandingsErrorLayoutPreview() {
    LazyColumn {
        standingsErrorLayout()
    }
}