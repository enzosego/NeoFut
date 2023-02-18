package com.ensegov.neofut.data.remote.standings.dto

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsDto(
    @SerialName("response")
    val responseItem: List<StandingsResponseItem>,
)

fun StandingsDto.asDatabaseModel(): CompetitionStandings? =
    if (responseItem.isEmpty())
        null
    else
        with(responseItem[0].competitionStandingsDto) {
            CompetitionStandings(
                id,
                groupList
            )
        }
