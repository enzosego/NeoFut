package com.ensegov.neofut.competition_detail.data.remote.standings

import com.ensegov.neofut.competition_detail.data.remote.standings.dto.StandingsDto
import com.ensegov.neofut.common.data.HttpRoutes
import com.ensegov.neofut.common.data.KtorClientApi
import com.ensegov.neofut.common.data.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*

class StandingsApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) : KtorClientApi(engine, logging, tag = "api_call_standings") {

    suspend fun getCurrentStandings(leagueId: Int, season: Int): StandingsDto =
        client.getWithToken(
            "${HttpRoutes.STANDINGS_REQUEST}?season=$season&league=$leagueId"
        ).body()
}