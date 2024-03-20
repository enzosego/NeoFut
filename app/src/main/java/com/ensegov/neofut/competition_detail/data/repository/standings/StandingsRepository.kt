package com.ensegov.neofut.competition_detail.data.repository.standings

import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup
import kotlinx.coroutines.flow.Flow

interface StandingsRepository {

    fun getStandings(id: Int, season: Int): Flow<List<CompetitionGroup>>

    suspend fun updateStandings(id: Int, season: Int)

    suspend fun canUpdateStandings(id: Int, season: Int): Boolean
}