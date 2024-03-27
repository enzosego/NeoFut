package com.ensegov.neofut.home.data.local.model

import com.ensegov.neofut.home.presentation.model.Coverage

data class CoverageData(
    val standings: Boolean,
    val players: Boolean,
    val goals: Boolean,
    val assists: Boolean,
    val events: Boolean,
    val lineups: Boolean,
    val statistics: Boolean,
    val injuries: Boolean
)

fun CoverageData.asUiModel() =
    Coverage(
        standings = standings,
        players = players,
        goals = goals,
        assists = assists,
        events = events,
        lineups = lineups,
        injuries = injuries
    )