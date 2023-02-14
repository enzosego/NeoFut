package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.standings.StandingsDto

interface CompetitionApi {
    suspend fun getCompetition(competitionId: String): Competition

    suspend fun getStandings(competitionId: String): StandingsDto
}