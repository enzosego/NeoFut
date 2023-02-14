package com.ensegov.neofut.data.remote.competition.dto.standings

import com.ensegov.neofut.data.remote.competition.dto.Season
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsDto(
    val season: Season,
    @SerialName("standings")
    val standingsList: List<Standings>
)