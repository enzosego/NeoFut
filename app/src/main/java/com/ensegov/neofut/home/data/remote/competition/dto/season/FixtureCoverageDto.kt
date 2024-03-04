package com.ensegov.neofut.home.data.remote.competition.dto.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixtureCoverageDto(
    val events: Boolean,
    val lineups: Boolean,
    @SerialName(value = "statistics_fixtures")
    val statisticsFixtures: Boolean,
    @SerialName(value = "statistics_players")
    val statisticsPlayers: Boolean,
)