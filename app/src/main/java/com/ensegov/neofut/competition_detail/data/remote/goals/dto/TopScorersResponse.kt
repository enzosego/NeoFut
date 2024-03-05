package com.ensegov.neofut.competition_detail.data.remote.goals.dto

import kotlinx.serialization.Serializable

@Serializable
data class TopScorersResponse(
    val response: List<TopScorerDto>
)
