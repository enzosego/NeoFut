package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.Serializable

@Serializable
data class Venue(
    val id: Int?,
    val name: String,
    val city: String
)