package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import kotlinx.coroutines.flow.Flow

interface CompetitionDetailRepository {

    val currentStandings: Flow<List<List<TeamPosition>>>

    suspend fun getStandings(id: Int, season: Int)
}