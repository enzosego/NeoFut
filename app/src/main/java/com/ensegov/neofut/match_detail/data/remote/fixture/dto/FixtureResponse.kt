package com.ensegov.neofut.match_detail.data.remote.fixture.dto

import kotlinx.serialization.Serializable

@Serializable
data class FixtureResponse(
    val response: List<MatchFixture>
)