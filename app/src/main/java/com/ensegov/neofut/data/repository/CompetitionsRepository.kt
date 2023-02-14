package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.remote.competition.CompetitionApi
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.standings.StandingsDto

class CompetitionsRepository(
    private val competitionDataSource: CompetitionApi
) {

    suspend fun getCompetition(): Competition =
        competitionDataSource.getCompetition("PL")

    suspend fun getStandings(): StandingsDto =
        competitionDataSource.getStandings("PL")
}