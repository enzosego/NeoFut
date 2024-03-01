package com.ensegov.neofut.home.data.remote.competition.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionInfo(
    val id: Int,
    val name: String,
    val type: String,
    @SerialName(value = "logo")
    val logoUrl: String?
)