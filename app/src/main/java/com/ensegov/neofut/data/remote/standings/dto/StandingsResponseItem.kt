package com.ensegov.neofut.data.remote.standings.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsResponseItem(
    @SerialName(value = "league")
    val competitionStandingsDto: CompetitionStandingsDto
)