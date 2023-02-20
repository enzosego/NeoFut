package com.ensegov.neofut.data.remote.standings

import com.ensegov.neofut.data.remote.standings.dto.StandingsDto
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*

class StandingsApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) {

    private val client = KtorClientBuilder(
        engine,
        logging,
        tag = "api_call_standings"
    ).client

    suspend fun getCurrentStandings(leagueId: Int, season: Int): StandingsDto =
        client.getWithToken(
            "${HttpRoutes.STANDINGS_REQUEST}?season=$season&league=$leagueId"
        ).body()
}