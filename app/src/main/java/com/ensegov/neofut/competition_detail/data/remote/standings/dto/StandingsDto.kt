package com.ensegov.neofut.competition_detail.data.remote.standings.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsDto(
    @SerialName("response")
    val itemList: List<StandingsResponseItem>,
)