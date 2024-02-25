package com.ensegov.neofut.data.local.model.competition.standings

import androidx.room.Embedded
import androidx.room.Relation

data class TeamPositionInfo(
    @Embedded val positionInfo: PositionInfo,
    @Relation(
        parentColumn = "team_id",
        entityColumn = "id"
    )
    val teamInfo: TeamInfo
)