package com.ensegov.neofut.match_detail.data.remote.events.dto

import kotlinx.serialization.Serializable

@Serializable
data class EventTimeDto(
    val elapsed: Int,
    val extra: Int? = null
)