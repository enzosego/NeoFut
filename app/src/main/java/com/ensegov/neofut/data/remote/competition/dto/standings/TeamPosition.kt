package com.ensegov.neofut.data.remote.competition.dto.standings

import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.serialization.Serializable

@Serializable
data class TeamPosition(
    val position: Int,
    val team: Team,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
)