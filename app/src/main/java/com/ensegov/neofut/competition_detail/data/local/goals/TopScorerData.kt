package com.ensegov.neofut.competition_detail.data.local.goals

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo

data class TopScorerData(
    @Embedded
    val goals: GoalData,
    @Relation(
        parentColumn = "player_id",
        entityColumn = "id"
    )
    val player: PlayerData,
    @Relation(
        parentColumn = "team_id",
        entityColumn = "id"
    )
    val team: TeamInfo
)
