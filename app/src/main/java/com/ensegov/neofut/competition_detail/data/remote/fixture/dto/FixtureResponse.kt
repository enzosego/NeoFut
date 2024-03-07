package com.ensegov.neofut.competition_detail.data.remote.fixture.dto

import kotlinx.serialization.Serializable

@Serializable
data class FixtureResponse(
    val response: List<MatchFixture>
)