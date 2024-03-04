package com.ensegov.neofut.home.data.repository

import com.ensegov.neofut.home.presentation.model.Competition

interface CompetitionsRepository {

    suspend fun fetchAllCompetitions(countryName: String): List<Competition>

    suspend fun getAllCompetitions(): List<Competition>
}