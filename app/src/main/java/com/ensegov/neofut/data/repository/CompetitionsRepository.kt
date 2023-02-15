package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.remote.competition.CompetitionApi
import com.ensegov.neofut.data.remote.competition.dto.AllCompetitions
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.standings.StandingsDto

class CompetitionsRepository(
    private val competitionDataSource: CompetitionApi
) {

    suspend fun getAllCompetitions(): List<Competition> =
        competitionDataSource.getAllCompetitions()

    suspend fun getCompetition(competitionId: String): Competition =
        competitionDataSource.getCompetition(competitionId)

    suspend fun getStandings(competitionId: String): StandingsDto =
        competitionDataSource.getStandings(competitionId)
}