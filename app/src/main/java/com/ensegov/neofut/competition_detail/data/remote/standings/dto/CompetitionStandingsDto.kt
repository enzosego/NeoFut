package com.ensegov.neofut.competition_detail.data.remote.standings.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionStandingsDto(
    @SerialName(value = "standings")
    val groupList: List<List<TeamPosition>>
)