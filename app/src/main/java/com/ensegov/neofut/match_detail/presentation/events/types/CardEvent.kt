package com.ensegov.neofut.match_detail.presentation.events.types

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun CardEvent(
    player: String,
    detail: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .height(21.dp)
                .width(14.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(
                    if (detail == "Yellow Card") Color.Yellow
                    else Color.Red
                )
        )
        Text(
            text = player,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Composable
private fun YellowCardEventPreview() {
    NeoFutTheme {
        CardEvent(player = "Pablo Pérez", detail = "Yellow Card")
    }
}

@Preview
@Composable
private fun RedCardEventPreview() {
    NeoFutTheme {
        CardEvent(player = "Sergio Ramos", detail = "Red Card")
    }
}