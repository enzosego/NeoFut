package com.ensegov.neofut.data.remote.competition.dto.standings

import kotlinx.serialization.Serializable

@Serializable
data class Standings(
    val type: String,
    val table: List<TeamPosition>
)