package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ensegov.neofut.domain.model.Competition
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CompetitionScreen(competition: Competition) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when(competition.type) {
            "League" -> LeagueDetail(competition)
            "Cup" -> CupDetail(competition)
        }
    }
}