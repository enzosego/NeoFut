package com.ensegov.neofut.data.remote.standings

import com.ensegov.neofut.data.remote.standings.dto.StandingsDto

interface StandingsApi {

    suspend fun getCurrentStandings(leagueId: Int, season: Int = 2022): StandingsDto
}