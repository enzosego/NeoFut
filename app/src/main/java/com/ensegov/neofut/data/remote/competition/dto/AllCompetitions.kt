package com.ensegov.neofut.data.remote.competition.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllCompetitions(
    @SerialName("competitions")
    val list: List<Competition>
)