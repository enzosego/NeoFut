package com.ensegov.neofut.match_detail.presentation.events.types

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.TurnSlightRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun GoalEvent(
    player: String,
    detail: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        if (detail == "Missed Penalty") {
            Box(
                modifier = Modifier
                    .width(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.SportsSoccer,
                    contentDescription = null,
                    tint = Color.Red
                )
                Icon(
                    imageVector = Icons.Filled.TurnSlightRight,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier
                        .height(16.dp)
                        .align(Alignment.BottomEnd)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                )
            }
        } else {
            Icon(
                imageVector = Icons.Filled.SportsSoccer,
                contentDescription = null,
                tint = if (detail == "Own Goal") Color.Red
                else MaterialTheme.colorScheme.onBackground
            )
        }
        Text(
            text = player,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NormalGoalEventPreview() {
    NeoFutTheme {
        GoalEvent(player = "Miguel Ángel Borja", detail = "Missed Penalty")
    }
}