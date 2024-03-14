package com.ensegov.neofut.competition_detail.presentation.fixture.match_day

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import com.ensegov.neofut.competition_detail.presentation.fixture.model.generateFakeMatch

@Composable
fun MatchCard(
    match: MatchUiShort,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(150.dp)
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            MatchTeamLayout(match.homeTeam)
            Text(text = "${match.data.homeScore}")
            VerticalDivider(thickness = 2.dp)
            Text(text = "${match.data.awayScore}")
            MatchTeamLayout(match.awayTeam)
        }
    }
}

@Preview
@Composable
fun MatchCardPreview() {
    MatchCard(
        generateFakeMatch(index = 0, count = 2)
    )
}