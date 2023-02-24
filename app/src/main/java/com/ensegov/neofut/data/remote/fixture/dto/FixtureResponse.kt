package com.ensegov.neofut.data.remote.fixture.dto

import com.ensegov.neofut.data.local.model.fixture.round.RoundFixtureData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FixtureResponse(
    val parameters: ParametersDto,
    @SerialName(value = "response")
    val fixture: List<MatchFixture>
)

fun FixtureResponse.asDatabaseModel() =
    RoundFixtureData(
        id = parameters.league,
        season = parameters.season,
        round = parameters.round ?: "",
        matchList = fixture
    )