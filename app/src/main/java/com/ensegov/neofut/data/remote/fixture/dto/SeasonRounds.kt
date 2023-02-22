package com.ensegov.neofut.data.remote.fixture.dto

import com.ensegov.neofut.data.local.model.fixture.SeasonFixtureData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SeasonRounds(
    val parameters: ParametersDto,
    @SerialName(value = "response")
    val roundList: List<String>
)

fun SeasonRounds.asDatabaseModel(): SeasonFixtureData {
    return SeasonFixtureData(
        parameters.league,
        parameters.season,
        roundList
    )
}