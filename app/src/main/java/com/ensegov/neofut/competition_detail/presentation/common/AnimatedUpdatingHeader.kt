package com.ensegov.neofut.competition_detail.presentation.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.ui.theme.NeoFutTheme

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.animatedUpdatingHeader(
    isUpdating: () -> Boolean,
    modifier: Modifier = Modifier
) {
    stickyHeader {
        AnimatedVisibility(
            visible = isUpdating(),
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Surface {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Updating",
                        fontSize = 18.sp
                    )
                    CirclesLoadingAnimation(
                        modifier = Modifier.padding(start = 8.dp)
                    )
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