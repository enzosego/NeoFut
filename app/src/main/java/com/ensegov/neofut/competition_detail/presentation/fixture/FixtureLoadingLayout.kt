package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
internal fun FixtureLoadingLayout(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(8) {
            FixtureLoadingItem()
        }
    }
}

@Preview
@Composable
private fun FixtureLoadingLayoutPreview() {
    NeoFutTheme {
        FixtureLoadingLayout()
    }
}