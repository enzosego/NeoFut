package com.ensegov.neofut.competition_detail.data.local.goals

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.presentation.goals.model.PlayerUiData
import com.ensegov.neofut.competition_detail.presentation.goals.model.TopScorerUiData

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

fun TopScorerData.asUiModel(position: Int) =
    TopScorerUiData(
        player = PlayerUiData(
            name = player.name,
            firstName = player.firstName,
            lastName = player.lastName,
            photoUrl = player.photoUrl
        ),
        position = position,
        totalGoals = goals.totalGoals,
        penaltyGoals = goals.penaltyGoals,
        teamName = team.name,
        teamLogoUrl = team.logoUrl ?: ""
    )
