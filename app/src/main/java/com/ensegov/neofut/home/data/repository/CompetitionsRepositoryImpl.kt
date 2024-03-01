package com.ensegov.neofut.home.data.repository

import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.home.data.local.model.asUiModel
import com.ensegov.neofut.home.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.home.data.remote.competition.dto.asDatabaseModel
import com.ensegov.neofut.home.data.remote.competition.dto.season.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.model.Competition
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