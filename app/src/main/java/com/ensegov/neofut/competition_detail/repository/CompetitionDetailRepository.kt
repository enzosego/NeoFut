package com.ensegov.neofut.competition_detail.repository

import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchUiShort
import kotlinx.coroutines.flow.Flow

interface CompetitionDetailRepository {

    suspend fun updateStandings(id: Int, season: Int)

    fun getStandings(id: Int, season: Int): Flow<List<CompetitionGroup>>

    suspend fun updateSeasonFixture(id: Int, season: Int)

    fun getSeasonFixture(id: Int, season: Int): Flow<List<String>>

    suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchUiShort>

    fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<MatchUiShort>>
}