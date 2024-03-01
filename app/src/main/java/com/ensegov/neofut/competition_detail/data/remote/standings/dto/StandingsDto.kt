package com.ensegov.neofut.competition_detail.data.remote.standings.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsDto(
    @SerialName("response")
    val responseItem: List<StandingsResponseItem>,
)

fun StandingsDto.asDatabaseModel(): List<List<TeamPosition>>? =
    if (responseItem.isEmpty())
        null
    else
        responseItem[0].competitionStandingsDto.groupList
