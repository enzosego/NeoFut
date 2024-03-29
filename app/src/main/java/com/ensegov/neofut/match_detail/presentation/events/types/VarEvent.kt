package com.ensegov.neofut.match_detail.presentation.events.types

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotInterested
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun VarEvent(
    detail: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.primary)
                .padding(3.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "VAR",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(2.dp)
            )
        }
        if (detail == "Goal Cancelled") {
            Box(
                modifier = Modifier
                    .padding(start = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.SportsSoccer,
                    contentDescription = null,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp)
                        .align(Alignment.Center)
                )
                Icon(
                    imageVector = Icons.Filled.NotInterested,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier
                        .height(35.dp)
                        .width(35.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Text(
            text = detail,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VarEventPreview() {
    NeoFutTheme {
        VarEvent(detail = "Penalty Confirmed")
    }
}