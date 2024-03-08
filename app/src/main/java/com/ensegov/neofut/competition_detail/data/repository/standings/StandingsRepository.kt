package com.ensegov.neofut.competition_detail.data.repository.standings

import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup

interface StandingsRepository {

    suspend fun updateStandings(id: Int, season: Int): List<CompetitionGroup>

    suspend fun getStandings(id: Int, season: Int): List<CompetitionGroup>

    suspend fun canUpdateStandings(id: Int, season: Int): Boolean
}