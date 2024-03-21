package com.ensegov.neofut.competition_detail.presentation.fixture.match_day

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.common.presentation.layout.LogoLayout
import com.ensegov.neofut.competition_detail.presentation.fixture.model.TeamInfoShort
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun MatchTeamLayout(
    team: TeamInfoShort,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LogoLayout(
            logoUrl = team.logoUrl,
            modifier = Modifier
                .height(80.dp)
                .padding(vertical = 10.dp)
        )
        Text(
            text = team.name,
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
private fun MatchTeamLayoutPreview() {
    NeoFutTheme {
        MatchTeamLayout(TeamInfoShort(name = "River Plate", logoUrl = ""))
    }
}