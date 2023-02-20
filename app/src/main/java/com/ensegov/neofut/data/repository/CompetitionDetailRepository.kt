package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import kotlinx.coroutines.flow.Flow

interface CompetitionDetailRepository {

    suspend fun updateStandings(id: Int, season: Int)

    fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?>
}