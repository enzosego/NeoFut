package com.ensegov.neofut.competition_detail.data.remote.team

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VenueDto(
    val id: Int?,
    val name: String?,
    val city: String?,
    val capacity: Int? = null,
    @SerialName(value = "image")
    val imageUrl: String? = null
)