package com.ensegov.neofut.data.remote.competition.dto.season

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coverage(
    @SerialName(value = "fixtures")
    val fixturesCoverage: FixturesCoverage,
    val standings: Boolean,
    val players: Boolean,
    @SerialName(value = "top_scorers")
    val topScorers: Boolean,
    @SerialName(value = "top_assists")
    val topAssists: Boolean,
    @SerialName(value = "top_cards")
    val topCards: Boolean,
    val injuries: Boolean,
    val predictions: Boolean,
    val odds: Boolean
)