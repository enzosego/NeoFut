package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier

internal fun LazyListScope.fixtureErrorLayout(
    modifier: Modifier = Modifier
) {
    item {
        Text(
            text = "An error has occurred when trying to load this competition's fixture",
            modifier = modifier.fillMaxWidth()
        )
    }
}