package com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match

import com.ensegov.neofut.competition_detail.data.remote.team.Venue
import kotlinx.serialization.Serializable

@Serializable
data class MatchInfo(
    val id: Int,
    val referee: String?,
    val timezone: String,
    val date: String,
    val venue: Venue,
    val status: MatchStatus
)