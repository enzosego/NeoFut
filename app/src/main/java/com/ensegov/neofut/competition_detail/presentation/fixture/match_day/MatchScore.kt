package com.ensegov.neofut.competition_detail.presentation.fixture.match_day

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.common.presentation.StatusValues
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun MatchStatusLayout(
    home: Int,
    away: Int,
    status: String,
    startTime: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight()
            .width(65.dp)
    ) {
        Text(
            text = when (status) {
                in StatusValues.explicit -> status
                in StatusValues.fullTime -> "FT"
                in StatusValues.showScore -> "LIVE"
                else -> ""
            },
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface
            ),
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
        ) {
            if (status in StatusValues.showScore)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "$home",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " - ",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "$away",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                else
                    Text(
                        text = if (status == "NS") startTime else status,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentHeight()
                            .background(MaterialTheme.colorScheme.inverseOnSurface)
                    )
        }
    }
}

@Preview
@Composable
private fun MatchScorePreview() {
    NeoFutTheme {
        MatchStatusLayout(
            home = 2,
            away = 1,
            status = "LIVE",
            startTime = "18:00"
        )
    }
}