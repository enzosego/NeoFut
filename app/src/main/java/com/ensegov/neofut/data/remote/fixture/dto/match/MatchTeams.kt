package com.ensegov.neofut.data.remote.fixture.dto.match

import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.serialization.Serializable

@Serializable
data class MatchTeams(
    val home: Team,
    val away: Team
)