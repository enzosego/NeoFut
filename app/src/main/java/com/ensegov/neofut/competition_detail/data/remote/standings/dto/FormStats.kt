package com.ensegov.neofut.competition_detail.data.remote.standings.dto

import com.ensegov.neofut.competition_detail.data.local.team.TeamForm
import kotlinx.serialization.Serializable

@Serializable
data class FormStats(
    val played: Int?,
    val win: Int?,
    val draw: Int?,
    val lose: Int?,
    val goals: GoalStats? = null
)

fun FormStats.asDatabaseModel(variation: String, teamId: Int, competitionId: Int) =
    TeamForm(
        variation = variation,
        teamId = teamId,
        competitionId = competitionId,
        played = played,
        win = win,
        draw = draw,
        lose = lose,
        goalsScored = goals?.scored,
        goalsAgainst = goals?.against
    )