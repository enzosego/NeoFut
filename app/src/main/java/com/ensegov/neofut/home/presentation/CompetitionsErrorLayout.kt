package com.ensegov.neofut.home.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CompetitionsErrorLayout(
    modifier: Modifier = Modifier
) {
    Text(
        text = "An error has occurred when trying to load available competitions",
        fontSize = 18.sp,
        modifier = modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
private fun CompetitionsErrorLayoutPreview() {
    CompetitionsErrorLayout()
}