package com.ensegov.neofut.competition_detail.data.repository.fixture

import com.ensegov.neofut.match_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {

    suspend fun updateSeasonRounds(id: Int, season: Int)

    fun getSeasonRounds(id: Int, season: Int): Flow<List<RoundName>>

    suspend fun updateCurrentRound(id: Int, season: Int)

    suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchDay>

    suspend fun getRoundFixture(id: Int, season: Int, round: String): List<MatchDay>

    suspend fun canUpdateSeasonRounds(id: Int, season: Int): Boolean

    suspend fun canUpdateCurrentRound(id: Int, season: Int): Boolean

    suspend fun canUpdateRoundFixture(id: Int, season: Int, round: String): Boolean
}