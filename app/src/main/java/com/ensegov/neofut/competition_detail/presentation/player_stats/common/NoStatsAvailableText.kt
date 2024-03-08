package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.R

@Composable
fun NoStatsAvailableText(
    stringRes: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(stringRes),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        modifier = modifier.fillMaxWidth()
    )
}