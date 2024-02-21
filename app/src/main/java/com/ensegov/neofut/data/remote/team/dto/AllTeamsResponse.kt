package com.ensegov.neofut.data.remote.team.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllTeamsResponse(
    @SerialName(value = "response")
    val teamList: List<TeamResponse>
)