package com.ensegov.neofut.data.remote.competition

import com.ensegov.neofut.data.remote.competition.dto.AllCompetitions
import com.ensegov.neofut.data.remote.competition.dto.Competition
import com.ensegov.neofut.data.remote.competition.dto.standings.StandingsDto
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class CompetitionApiImpl(
    private val client: HttpClient
) : CompetitionApi {

    override suspend fun getAllCompetitions(): List<Competition> =
        client.getWithToken(HttpRoutes.COMPETITION_REQUEST)
            .body<AllCompetitions>().list

    override suspend fun getCompetition(competitionId: String): Competition =
        client.getWithToken("${HttpRoutes.COMPETITION_REQUEST}$competitionId")
            .body()

    override suspend fun getStandings(competitionId: String): StandingsDto =
        client.getWithToken("${HttpRoutes.COMPETITION_REQUEST}$competitionId/standings")
            .body()


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