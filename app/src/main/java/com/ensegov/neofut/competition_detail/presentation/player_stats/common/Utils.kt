package com.ensegov.neofut.competition_detail.presentation.player_stats.common

import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerUiData

fun getStatsList() =
    List(20) {
        PlayerStatsUiData(
            player = PlayerUiData(
                name = "Player Number $it",
                firstName = "Player",
                lastName = "Number",
                photoUrl = ""
            ),
            position = it,
            totalGoals = 13,
            penaltyGoals = 2,
            assists = 25 - it,
            teamName = "Team - $it",
            teamLogoUrl = ""
        )
    }

fun getFakePlayerStats() =
    PlayerStatsUiData(
        player = PlayerUiData(
            name = "Franco Mastantuono",
            firstName = "Franco",
            lastName = "Mastantuono",
            photoUrl = ""
        ),
        position = 4,
        totalGoals = 1,
        penaltyGoals = 0,
        assists = 0,
        teamName = "River Plate",
        teamLogoUrl = ""
    )