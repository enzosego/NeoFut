package com.ensegov.neofut.home.presentation.model

import com.ensegov.neofut.competition_detail.presentation.model.CompetitionDetailTab
import kotlinx.serialization.Serializable

@Serializable
data class Coverage(
    val standings: Boolean,
    val players: Boolean,
    val goals: Boolean,
    val assists: Boolean,
    val events: Boolean,
    val lineups: Boolean,
    val injuries: Boolean
)

fun Coverage.toTabList() = listOf(
    CompetitionDetailTab.Fixture(),
    CompetitionDetailTab.Standings(hasCoverage = standings),
    CompetitionDetailTab.Goals(hasCoverage = goals),
    CompetitionDetailTab.Assists(hasCoverage = assists)
)