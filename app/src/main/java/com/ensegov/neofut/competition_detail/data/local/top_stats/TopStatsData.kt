package com.ensegov.neofut.competition_detail.data.local.top_stats

import androidx.room.Embedded
import androidx.room.Relation
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData

data class TopStatsData(
    @Embedded
    val goals: StatsData,
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

fun TopStatsData.asUiModel(position: Int) =
    PlayerStatsUiData(
        player = PlayerUiData(
            name = player.name,
            firstName = player.firstName,
            lastName = player.lastName,
            photoUrl = player.photoUrl
        ),
        position = position,
        totalGoals = goals.totalGoals,
        penaltyGoals = goals.penaltyGoals,
        assists = goals.assists,
        teamName = team.name,
        teamLogoUrl = team.logoUrl ?: ""
    )