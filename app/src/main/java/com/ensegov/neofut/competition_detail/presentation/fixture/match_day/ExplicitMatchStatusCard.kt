package com.ensegov.neofut.competition_detail.presentation.fixture.match_day

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExplicitMatchStatusCard(
    status: String,
    modifier: Modifier = Modifier
) {
   Card {
       Text(
           text = status,
           fontSize = 18.sp,
           fontWeight = FontWeight.Bold,
           textAlign = TextAlign.Center,
           modifier = modifier
               .height(40.dp)
               .width(65.dp)
               .background(MaterialTheme.colorScheme.inverseOnSurface)
               .wrapContentHeight(Alignment.CenterVertically)
       )
   }
}