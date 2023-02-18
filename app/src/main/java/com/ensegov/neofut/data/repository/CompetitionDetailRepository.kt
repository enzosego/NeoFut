package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.remote.standings.StandingsApi
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.remote.standings.dto.asDatabaseModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class CompetitionDetailRepository(
    private val database: NeoFutDatabase,
    private val standingsDataSource: StandingsApi,
    private val ioDispatcher: CoroutineDispatcher
) {

    private val competitionId = MutableStateFlow(-1)

    private val allStandings: Flow<List<CompetitionStandings>> =
        database.competitionStandingsDao.getAll()

    val currentStandings: Flow<List<List<TeamPosition>>> = callbackFlow {
        allStandings.collectValue(ioDispatcher) { list ->
            val newStandings = list.find { it.id == competitionId.value }
                ?.groupList ?: emptyList()

            send(newStandings)
        }
        competitionId.collectValue(ioDispatcher) { newId ->
            if (newId < 0)
                return@collectValue

            val newStandings = allStandings.first().find { it.id == newId }
                ?.groupList ?: emptyList()

            send(newStandings)
        }
        awaitClose()
    }

    suspend fun getStandings(id: Int, season: Int) = withContext(ioDispatcher) {
        competitionId.emit(id)
        if (allStandings.first().any { it.id == id })
            return@withContext

        val newValue = standingsDataSource.getCurrentStandings(id, season).asDatabaseModel()
            ?: return@withContext
        database.competitionStandingsDao.upsert(newValue)
    }
}