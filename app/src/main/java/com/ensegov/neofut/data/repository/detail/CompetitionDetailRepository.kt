package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.fixture.round.RoundFixtureData
import com.ensegov.neofut.data.local.model.fixture.season.SeasonFixtureData
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import kotlinx.coroutines.flow.Flow

interface CompetitionDetailRepository {

    suspend fun updateStandings(id: Int, season: Int)

    fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?>

    suspend fun updateSeasonFixture(id: Int, season: Int)

    fun getSeasonFixture(id: Int, season: Int): Flow<SeasonFixtureData?>

    suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchFixture>

    fun getRoundFixture(id: Int, season: Int, round: String): Flow<RoundFixtureData?>
}