package com.ensegov.neofut.data.remote.standings.dto

import com.ensegov.neofut.data.local.model.competition.standings.PositionInfo
import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamPosition(
    @SerialName(value = "rank")
    val position: Int,
    val team: Team,
    val points: Int,
    val goalsDiff: Int,
    val group: String,
    val form: String?,
    val status: String?,
    val description: String?,
    @SerialName(value = "all")
    val allMatches: FormStats,
    @SerialName(value = "home")
    val homeMatches: FormStats,
    @SerialName(value = "away")
    val awayMatches: FormStats,
)

fun TeamPosition.asDatabaseModel(competitionId: Int, season: Int) =
    PositionInfo(
        competitionId = competitionId,
        teamId = team.id,
        season = season,
        position = position,
        points = points,
        goalsDiff = goalsDiff,
        group = group,
        form = form,
        status = status,
        description = description
    )