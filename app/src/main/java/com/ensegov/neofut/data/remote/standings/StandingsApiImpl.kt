package com.ensegov.neofut.data.remote.standings

import com.ensegov.neofut.data.remote.standings.dto.StandingsDto
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.*
import io.ktor.client.call.*

class StandingsApiImpl(
    private val client: HttpClient
) : StandingsApi {

    override suspend fun getCurrentStandings(leagueId: Int, season: Int): StandingsDto =
        client.getWithToken(
            "${HttpRoutes.STANDINGS_REQUEST}?season=$season&league=$leagueId"
        ).body()

    companion object {
        fun create(): StandingsApi =
            StandingsApiImpl(
                KtorClientBuilder(
                    isLoggingEnabled = true,
                    tag = "standings_api_call"
                ).client
            )
    }
}