package com.ensegov.neofut.competition_detail.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.animatedUpdatingHeader(
    isUpdating: () -> Boolean,
    modifier: Modifier = Modifier
) {
    stickyHeader {
        AnimatedVisibility(isUpdating()) {
            Surface {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Updating...")
                }
            }
        }
    }
}

@Preview
@Composable
private fun AnimatedUpdatingHeaderPreview() {
    NeoFutTheme {
        LazyColumn {
            animatedUpdatingHeader({ true })
        }
    }
}