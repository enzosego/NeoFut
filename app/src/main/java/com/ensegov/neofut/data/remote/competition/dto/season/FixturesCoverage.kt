package com.ensegov.neofut.data.remote.competition.dto.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixturesCoverage(
    val events: Boolean,
    val lineups: Boolean,
    @SerialName(value = "statistics_fixtures")
    val fixtureStatistics: Boolean,
    @SerialName(value = "statistics_players")
    val playerStatistics: Boolean
)