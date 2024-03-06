package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun StatsTitle(
    text: String,
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        modifier = Modifier.fillMaxWidth()
    )
}