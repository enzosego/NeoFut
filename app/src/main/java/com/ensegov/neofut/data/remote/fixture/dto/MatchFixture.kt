package com.ensegov.neofut.data.remote.fixture.dto

import com.ensegov.neofut.data.remote.fixture.dto.match.AllMatchScores
import com.ensegov.neofut.data.remote.fixture.dto.match.MatchInfo
import com.ensegov.neofut.data.remote.fixture.dto.match.MatchScore
import com.ensegov.neofut.data.remote.fixture.dto.match.MatchTeams
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchFixture(
    @SerialName(value = "fixture")
    val info: MatchInfo,
    val teams: MatchTeams,
    @SerialName(value = "goals")
    val currentScore: MatchScore,
    val score: AllMatchScores
)