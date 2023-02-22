package com.ensegov.neofut.ui.competition.fixture

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RoundFixture(round: String) {

    Text(text = round,
        modifier = Modifier.fillMaxWidth()
    )
}