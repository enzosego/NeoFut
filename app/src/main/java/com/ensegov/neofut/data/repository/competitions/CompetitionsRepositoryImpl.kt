package com.ensegov.neofut.data.repository.competitions

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.info.asUiModel
import com.ensegov.neofut.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.data.remote.competition.dto.asDatabaseModel
import com.ensegov.neofut.data.remote.competition.dto.season.asDatabaseModel
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CompetitionsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val competitionsApi: CompetitionsApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionsRepository {

    override suspend fun fetchAllCompetitions(countryName: String) {
        val result = competitionsApi.getCountryCompetitions(countryName)
        val newList = result
            .map { it.asDatabaseModel() }
        val seasons = result.map { competition ->
            competition.seasons.map { season ->
                season.asDatabaseModel(competition.info.id)
            }
        }.flatten()
        withContext(ioDispatcher) {
            database.competitionDao.insertAllCompetitions(*newList.toTypedArray())
            database.competitionDao.insertAllSeasons(*seasons.toTypedArray())
        }
    }

    override fun getAllCompetitions(): Flow<List<Competition>> =
        database.competitionDao.getAll()
            .map { list ->
                list.map { (competition, seasons) ->
                    competition.asUiModel(seasons)
                }
            }
}