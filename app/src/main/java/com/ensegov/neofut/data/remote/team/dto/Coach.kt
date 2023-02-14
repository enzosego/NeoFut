package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.Serializable

@Serializable
data class Coach(
    val firstName: String,
    val lastName: String,
    val name: String,
    val nationality: String
)
