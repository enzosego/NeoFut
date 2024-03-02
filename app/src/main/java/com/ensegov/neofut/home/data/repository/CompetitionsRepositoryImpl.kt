package com.ensegov.neofut.home.data.repository

import android.util.Log
import com.ensegov.neofut.NeoFutDatabase
import com.ensegov.neofut.home.data.local.model.asUiModel
import com.ensegov.neofut.home.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.home.data.remote.competition.dto.asDatabaseModel
import com.ensegov.neofut.home.data.remote.competition.dto.season.asDatabaseModel
import com.ensegov.neofut.competition_detail.presentation.model.Competition
import com.ensegov.neofut.home.data.remote.competition.dto.asUiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CompetitionsRepositoryImpl(
    private val database: NeoFutDatabase,
    private val competitionsApi: CompetitionsApi,
    private val ioDispatcher: CoroutineDispatcher
) : CompetitionsRepository {

    override suspend fun fetchAllCompetitions(countryName: String): List<Competition> {
        val result = competitionsApi.getCountryCompetitions(countryName)
        val newList = result
            .map {
                Log.d("CompetitionsRepository", "${it.info.id}")
                it.asDatabaseModel()
            }
        val seasons = result.map { competition ->
            competition.seasons.map { season ->
                season.asDatabaseModel(competition.info.id)
            }
        }.flatten()
        withContext(ioDispatcher) {
            database.competitionDao.insertAllCompetitions(*newList.toTypedArray())
            database.competitionDao.insertAllSeasons(*seasons.toTypedArray())
        }
        return result.map {
            it.asUiModel()
        }
    }

    override suspend fun getAllCompetitions(): List<Competition> =
        withContext(ioDispatcher) {
            database.competitionDao.getAll()
                .map { (competition, seasons) ->
                    competition.asUiModel(seasons)
                }
        }
}