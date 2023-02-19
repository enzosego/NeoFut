package com.ensegov.neofut.data.remote.fixture.dto

import com.ensegov.neofut.data.local.model.fixture.FixtureData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rounds(
    val parameters: ParametersDto,
    @SerialName(value = "response")
    val roundList: List<String>
)

fun Rounds.asDatabaseModel() =
    FixtureData(
        parameters.league,
        parameters.season,
        roundList.size
    )