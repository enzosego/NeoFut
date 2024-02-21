package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Venue(
    val id: Int?,
    val name: String?,
    val city: String?,
    val capacity: Int? = null,
    @SerialName(value = "image")
    val imageUrl: String? = null
)