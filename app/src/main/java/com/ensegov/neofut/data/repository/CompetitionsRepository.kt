package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.info.asDomainModel
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.asDatabaseModel
import com.ensegov.neofut.data.remote.competition.dto.standings.Standings
import com.ensegov.neofut.data.remote.competition.dto.standings.asDatabaseModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

class CompetitionsRepository(
    private val database: NeoFutDatabase,
    private val competitionDataSource: CompetitionsApi,
    private val ioDispatcher: CoroutineDispatcher
) {

    val allCompetitions: Flow<List<Competition>> = database.competitionInfoDao.getAll()
        .map { list ->
            list.map { it.asDomainModel() }
        }

    private val competitionId = MutableStateFlow("")

    private val allStandingsFlow: Flow<List<CompetitionStandings>> =
        database.competitionStandingsDao.getAll()

    private lateinit var allStandings: List<CompetitionStandings>

    val currentStandings: Flow<List<Standings>> = callbackFlow {
        allStandingsFlow.collectValue(ioDispatcher) { list ->
            val newStandings = list.find { it.id == competitionId.value }
                ?.standingsList ?: emptyList()

            send(newStandings)
        }
        competitionId.collectValue(ioDispatcher) { newId ->
            if (newId.isEmpty())
                return@collectValue

            val newStandings = allStandings.find { it.id == newId }
                ?.standingsList ?: emptyList()

            send(newStandings)
        }
        awaitClose()
    }

    init {
        allStandingsFlow.collectValue(ioDispatcher) { allStandings = it }
    }

    suspend fun getAllCompetitions() = withContext(ioDispatcher) {
        if (allCompetitions.first().isNotEmpty())
            return@withContext

        val newList = competitionDataSource.getAllCompetitions()
            .map { it.asDatabaseModel() }
        database.competitionInfoDao.insertOrUpdateAll(*newList.toTypedArray())
    }

    suspend fun setStandings(newId: String) = withContext(ioDispatcher) {
        competitionId.emit(newId)
        if (allStandings.any { it.id == newId })
            return@withContext

        val newValue = competitionDataSource.getStandings(newId)
        database.competitionStandingsDao.insertOrUpdate(newValue.asDatabaseModel())
    }
}