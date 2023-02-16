package com.ensegov.neofut.data.remote.competition.dto.standings

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.Season
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StandingsDto(
    val competition: Competition,
    val season: Season,
    @SerialName("standings")
    val standingsList: List<Standings>,
)

fun StandingsDto.asDatabaseModel() =
    CompetitionStandings(
        competition.code,
        standingsList
    )