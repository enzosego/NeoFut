package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.Serializable

@Serializable
data class TeamResponse(
    val team: Team,
    val venue: Venue
)