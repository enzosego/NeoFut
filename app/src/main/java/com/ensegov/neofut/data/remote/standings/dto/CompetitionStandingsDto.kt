package com.ensegov.neofut.data.remote.standings.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionStandingsDto(
    val id: Int,
    val name: String,
    @SerialName(value = "country")
    val countryName: String,
    @SerialName(value = "logo")
    val logoUrl: String?,
    @SerialName(value = "flag")
    val flagUrl: String?,
    val season: Int,
    @SerialName(value = "standings")
    val groupList: List<List<TeamPosition>>
)