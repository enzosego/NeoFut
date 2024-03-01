package com.ensegov.neofut.competition_detail.data.remote.fixture.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeasonRounds(
    val parameters: ParametersDto,
    @SerialName(value = "response")
    val roundList: List<String>
)