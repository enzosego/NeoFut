package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FixtureErrorLayout(
    modifier: Modifier = Modifier
) {
    Text(
        text = "An error has occurred when trying to load this competition's fixture",
        modifier = modifier.fillMaxWidth()
    )
}