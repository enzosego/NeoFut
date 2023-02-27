package com.ensegov.neofut.data.repository

import com.ensegov.neofut.domain.model.Competition
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun fetchAllCompetitions(countryName: String)

    fun getAllCompetitions(): Flow<List<Competition>>
}