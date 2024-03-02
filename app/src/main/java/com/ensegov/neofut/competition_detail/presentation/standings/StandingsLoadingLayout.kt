package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

internal fun LazyListScope.standingsLoadingLayout(
    modifier: Modifier = Modifier
) {
    item {
        Column(
            modifier = modifier
        ) {
            repeat(12) {
                StandingsLoadingItem()
            }
        }
    }
}

@Preview
@Composable
private fun StandingsLoadingLayoutPreview() {
    LazyColumn {
        standingsLoadingLayout()
    }
}