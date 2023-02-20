package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: Int,
    val name: String,
    @SerialName(value = "logo")
    val logoUrl: String?,
    val winner: Boolean? = null
)