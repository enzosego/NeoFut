package com.ensegov.neofut.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.home.presentation.model.Competition
import com.ensegov.neofut.home.data.remote.competition.dto.Country
import com.ensegov.neofut.ui.common.LogoLayout
import com.ensegov.neofut.ui.theme.NeoFutTheme

@Composable
fun CompetitionCard(
    competition: Competition,
    onClickAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClickAction,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = competition.name,
                fontSize = 18.sp,
                modifier = Modifier.height(20.dp)
            )
            LogoLayout(
                logoUrl = competition.logoUrl,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
        }
    }
}

@Preview
@Composable
private fun CompetitionCardPreview() {
    NeoFutTheme {
        CompetitionCard(
            competition = Competition(
                id = 14,
                name = "Champions League",
                type = "Cup",
                logoUrl = "",
                country = Country(name = "", code = null, flagUrl = ""),
                seasons = emptyList()
            ),
            onClickAction = {  }
        )
    }
}