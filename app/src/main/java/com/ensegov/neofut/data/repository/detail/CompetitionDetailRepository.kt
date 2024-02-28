package com.ensegov.neofut.data.repository.detail

import com.ensegov.neofut.data.local.model.fixture.SimpleMatchFixture
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.ui.competition.model.CompetitionGroup
import com.ensegov.neofut.ui.competition.model.MatchUiShort
import kotlinx.coroutines.flow.Flow

interface CompetitionDetailRepository {

    suspend fun updateStandings(id: Int, season: Int)

    fun getStandings(id: Int, season: Int): Flow<List<CompetitionGroup>>

    suspend fun updateSeasonFixture(id: Int, season: Int)

    fun getSeasonFixture(id: Int, season: Int): Flow<List<String>>

    suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchUiShort>

    fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<MatchUiShort>>
}