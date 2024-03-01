package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

internal fun LazyListScope.fixtureLoadingLayout(
    modifier: Modifier = Modifier
) {
    item {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(8) {
                LoadingListItem()
            }
        }
    }
}

@Preview
@Composable
private fun FixtureLoadingLayoutPreview() {
    LazyColumn {
        fixtureLoadingLayout()
    }
}