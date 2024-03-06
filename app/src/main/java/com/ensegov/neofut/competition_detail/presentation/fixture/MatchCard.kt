package com.ensegov.neofut.competition_detail.presentation.fixture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDataShort
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import com.ensegov.neofut.competition_detail.presentation.fixture.model.TeamInfoShort
import com.ensegov.neofut.common.presentation.layout.LogoLayout

@Composable
fun MatchCard(
    match: MatchUiShort,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .background(MaterialTheme.colorScheme.secondary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        LogoLayout(
            logoUrl = match.homeTeam.logoUrl,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp)
        )
        Text(
            text = match.homeTeam.name,
            fontSize = 18.sp,
            modifier = Modifier.width(120.dp)
        )
        Text(text = "${match.data.homeScore}")
        VerticalDivider(thickness = 2.dp)
        Text(text = "${match.data.awayScore}")
        Text(
            text = match.awayTeam.name,
            fontSize = 18.sp,
            modifier = Modifier.width(120.dp)
        )
        LogoLayout(
            logoUrl = match.awayTeam.logoUrl,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 10.dp)
        )
    }
}

@Preview
@Composable
fun MatchCardPreview() {
    MatchCard(
        MatchUiShort(
            data = MatchDataShort(
                id = 1,
                homeScore = 2,
                awayScore = 1,
                status = "",
                timeElapsed = 48
            ),
            homeTeam = TeamInfoShort(
                name = "River Plate",
                logoUrl = ""
            ),
            awayTeam = TeamInfoShort(
                name = "Boca Juniors",
                logoUrl = ""
            )
        )
    )
}