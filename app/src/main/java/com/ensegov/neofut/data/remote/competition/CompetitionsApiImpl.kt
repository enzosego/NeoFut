package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.data.remote.competition.dto.AllCompetitions
import com.ensegov.neofut.data.remote.competition.dto.CompetitionDto
import com.ensegov.neofut.data.remote.standings.dto.StandingsDto
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.*
import io.ktor.client.call.*

class CompetitionsApiImpl(
    private val client: HttpClient
) : CompetitionsApi {

    override suspend fun getCountryCompetitions(countryName: String): List<CompetitionDto> =
        client.getWithToken(
            "${HttpRoutes.COMPETITION_REQUEST}?country=$countryName&current=true"
        ).body<AllCompetitions>().list

    override suspend fun getStandings(leagueId: Int, season: Int): StandingsDto =
        client.getWithToken(
            "${HttpRoutes.STANDINGS_REQUEST}?league=$leagueId&season=$season"
        ).body()


    companion object {
        fun create(): CompetitionsApi =
            CompetitionsApiImpl(
                KtorClientBuilder(
                    isLoggingEnabled = true,
                    tag = "competition_api_call"
                ).client
            )
    }
}