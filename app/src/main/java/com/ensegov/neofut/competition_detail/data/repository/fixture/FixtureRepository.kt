package com.ensegov.neofut.competition_detail.data.repository.fixture

import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {

    suspend fun updateSeasonFixture(id: Int, season: Int)

    fun getSeasonFixture(id: Int, season: Int): Flow<List<String>>

    suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchUiShort>

    fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<MatchUiShort>>

    suspend fun canUpdateSeasonRounds(id: Int, season: Int): Boolean

    suspend fun canUpdateRoundFixture(id: Int, season: Int, round: String): Boolean
}