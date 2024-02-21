package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: Int,
    val name: String,
    val code: String? = null,
    @SerialName(value = "logo")
    val logoUrl: String?,
    val founded: Int? = null,
    val winner: Boolean? = null
)