package com.ensegov.neofut.match_detail.data.remote.fixture.dto.match

import com.ensegov.neofut.competition_detail.data.remote.team.Team
import kotlinx.serialization.Serializable

@Serializable
data class MatchTeams(
    val home: Team,
    val away: Team
)