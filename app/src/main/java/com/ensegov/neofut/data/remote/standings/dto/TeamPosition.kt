package com.ensegov.neofut.data.remote.standings.dto

import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamPosition(
    @SerialName(value = "rank")
    val position: Int,
    val team: Team,
    val points: Int,
    val goalsDiff: Int,
    val group: String,
    val form: String?,
    val status: String?,
    val description: String?,
    @SerialName(value = "all")
    val allMatches: FormStats,
    @SerialName(value = "home")
    val homeMatches: FormStats,
    @SerialName(value = "away")
    val awayMatches: FormStats,
)