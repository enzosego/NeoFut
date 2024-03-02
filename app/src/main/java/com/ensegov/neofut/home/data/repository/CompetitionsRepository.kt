package com.ensegov.neofut.home.data.repository

import com.ensegov.neofut.competition_detail.presentation.model.Competition
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun fetchAllCompetitions(countryName: String): List<Competition>

    suspend fun getAllCompetitions(): List<Competition>
}