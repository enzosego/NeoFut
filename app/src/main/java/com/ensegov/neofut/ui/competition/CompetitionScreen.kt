package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CompetitionScreen(competition: Competition) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when(competition.type) {
            "LEAGUE" -> LeagueDetail(competition)
            else -> Text(text = competition.name)
        }
    }
}