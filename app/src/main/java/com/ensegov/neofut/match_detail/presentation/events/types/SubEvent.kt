package com.ensegov.neofut.match_detail.presentation.events.types

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun SubEvent(
    into: String,
    out: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(text = into)
        Box(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowUpward,
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )
            Icon(
                imageVector = Icons.Filled.ArrowDownward,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .align(Alignment.BottomEnd)
            )
        }
        Text(text = out)
    }
}

@Preview
@Composable
private fun SubEventPreview() {
    NeoFutTheme {
        SubEvent(into = "Exequiel Palacios", out = "Rodrigo De Paul", )
    }
}