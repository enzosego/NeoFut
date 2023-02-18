package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.NeoFutDatabase
import com.ensegov.neofut.data.local.model.competition.info.CompetitionData
import com.ensegov.neofut.data.remote.competition.CompetitionsApi
import com.ensegov.neofut.data.remote.competition.dto.asDatabaseModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class CompetitionsRepository(
    private val database: NeoFutDatabase,
    private val competitionsDataSource: CompetitionsApi
) {

    val allCompetitions: Flow<List<CompetitionData>> = database.competitionDataDao.getAll()

    suspend fun getAllCompetitions() {
        if (allCompetitions.first().isNotEmpty())
            return

        val newList = competitionsDataSource.getCountryCompetitions("argentina")
            .map { it.asDatabaseModel() }
        database.competitionDataDao.upsertAll(*newList.toTypedArray())
    }
}