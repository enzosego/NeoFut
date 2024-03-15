package com.ensegov.neofut.competition_detail.data.remote.team

import com.ensegov.neofut.competition_detail.data.local.team.VenueData
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

fun VenueDto.asDatabaseModel(): VenueData? =
    if (id == null || name == null)
        null
    else
        VenueData(
            id = id,
            name = name,
            city = city,
            capacity = capacity,
            imageUrl = imageUrl
        )