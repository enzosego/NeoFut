package com.ensegov.neofut.competition_detail.data.remote.fixture.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixtureResponse(
    val parameters: ParametersDto,
    @SerialName(value = "response")
    val fixture: List<MatchFixture>
)