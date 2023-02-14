package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val name: String,
    val shortName: String,
    val tla: String,
)