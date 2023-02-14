package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.standings.StandingsDto
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class CompetitionApiImpl(
    private val client: HttpClient
) : CompetitionApi {

    override suspend fun getCompetition(competitionId: String): Competition =
        client.get("${HttpRoutes.COMPETITION_REQUEST}$competitionId") {
            header("X-Auth-Token", HttpRoutes.API_TOKEN)
        }.body()

    override suspend fun getStandings(competitionId: String): StandingsDto =
        client.get("${HttpRoutes.COMPETITION_REQUEST}$competitionId/standings") {
            header("X-Auth-Token", HttpRoutes.API_TOKEN)
        }.body()


    companion object {
        fun create(): CompetitionApi =
            CompetitionApiImpl(
                KtorClientBuilder(
                    isLoggingEnabled = true,
                    tag = "competition_api_call"
                ).client
            )
    }
}