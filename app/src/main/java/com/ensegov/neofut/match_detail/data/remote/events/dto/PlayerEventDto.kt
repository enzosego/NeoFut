package com.ensegov.neofut.match_detail.data.remote.events.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlayerEventDto(
    val id: Int?,
    val name: String?
)