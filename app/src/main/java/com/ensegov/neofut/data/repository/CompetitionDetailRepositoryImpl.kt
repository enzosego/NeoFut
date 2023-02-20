package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.remote.standings.StandingsApi
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.remote.standings.dto.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class CompetitionDetailRepositoryImpl(
    private val database: NeoFutDatabase,
    private val standingsDataSource: StandingsApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionDetailRepository {

    override suspend fun updateStandings(id: Int, season: Int) = withContext(ioDispatcher) {
        val newValue = standingsDataSource.getCurrentStandings(id, season).asDatabaseModel()
            ?: return@withContext
        database.competitionStandingsDao.upsert(newValue)
    }

    override fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?> =
        database.competitionStandingsDao.getStandings(id, season)
}