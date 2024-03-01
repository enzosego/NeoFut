package com.ensegov.neofut.competition_detail.data.local.standings

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.competition_detail.presentation.standings.model.PositionUiData
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo

data class TeamPositionInfo(
    @Embedded val positionInfo: PositionInfo,
    @Relation(
        parentColumn = "team_id",
        entityColumn = "id"
    )
    val teamInfo: TeamInfo
)

fun TeamPositionInfo.asUiModel() =
    PositionUiData(
        team = teamInfo.name,
        teamLogo = teamInfo.logoUrl ?: "",
        position = positionInfo.position,
        points = positionInfo.points,
        goalsDiff = positionInfo.goalsDiff,
        form = positionInfo.form,
        status = positionInfo.status,
        description = positionInfo.description
    )