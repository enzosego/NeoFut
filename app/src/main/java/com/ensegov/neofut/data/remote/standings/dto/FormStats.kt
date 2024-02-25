package com.ensegov.neofut.data.remote.standings.dto

import com.ensegov.neofut.data.local.model.competition.standings.TeamForm
import kotlinx.serialization.Serializable

@Serializable
data class FormStats(
    val played: Int?,
    val win: Int?,
    val draw: Int?,
    val lose: Int?,
    val goals: GoalStats? = null
)

fun FormStats.asDatabaseModel(variation: String, teamId: Int) =
    TeamForm(
        variation = variation,
        teamId = teamId,
        played = played,
        win = win,
        draw = draw,
        lose = lose,
        goalsScored = goals?.scored,
        goalsAgainst = goals?.against
    )