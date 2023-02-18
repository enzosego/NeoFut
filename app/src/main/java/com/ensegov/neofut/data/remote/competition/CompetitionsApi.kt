package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.data.remote.competition.dto.CompetitionDto
import com.ensegov.neofut.data.remote.standings.dto.StandingsDto

interface CompetitionsApi {

    suspend fun getCountryCompetitions(countryName: String): List<CompetitionDto>

    suspend fun getStandings(leagueId: Int, season: Int): StandingsDto
}