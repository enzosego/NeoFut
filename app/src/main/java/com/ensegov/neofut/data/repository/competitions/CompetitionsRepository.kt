package com.ensegov.neofut.data.repository.competitions

import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun fetchAllCompetitions(countryName: String)

    fun getAllCompetitions(): Flow<List<Competition>>
}