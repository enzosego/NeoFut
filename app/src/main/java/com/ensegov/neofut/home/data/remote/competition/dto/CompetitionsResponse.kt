package com.ensegov.neofut.home.data.remote.competition.dto

import kotlinx.serialization.Serializable

@Serializable
data class CompetitionsResponse(
    val response: List<CompetitionDto>
)