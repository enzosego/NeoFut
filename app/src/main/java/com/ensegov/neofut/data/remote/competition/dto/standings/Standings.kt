package com.ensegov.neofut.data.remote.competition.dto.standings

import kotlinx.serialization.Serializable

@Serializable
data class Standings(
    val stage: String,
    val type: String,
    val group: String?,
    val table: List<TeamPosition>
)