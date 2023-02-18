package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.info.CompetitionData
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    val allCompetitions: Flow<List<CompetitionData>>

    suspend fun getAllCompetitions() {}
}