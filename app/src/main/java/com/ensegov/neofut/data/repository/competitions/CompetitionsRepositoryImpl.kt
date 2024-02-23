package com.ensegov.neofut.data.repository.competitions

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.info.asDomainModel
import com.ensegov.neofut.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.data.remote.competition.dto.asDatabaseModel
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

class CompetitionsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val competitionsApi: CompetitionsApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionsRepository {

    override suspend fun fetchAllCompetitions(countryName: String) {
        val newList = competitionsApi.getCountryCompetitions(countryName)
            .map { it.asDatabaseModel() }
        withContext(ioDispatcher) {
            database.competitionDao.upsertAll(*newList.toTypedArray())
        }
    }

    override fun getAllCompetitions(): Flow<List<Competition>> =
        database.competitionDao.getAll()
            .map { list ->
                list.map { it.asDomainModel() }
            }
}