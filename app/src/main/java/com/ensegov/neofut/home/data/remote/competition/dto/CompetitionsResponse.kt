package com.ensegov.neofut.home.data.remote.competition.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionsResponse(
    @SerialName(value = "response")
    val list: List<CompetitionDto>
)