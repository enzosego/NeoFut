package com.ensegov.neofut.competition_detail.data.remote.top_stats

import com.ensegov.neofut.competition_detail.data.remote.top_stats.dto.TopStatsResponse
import com.ensegov.neofut.common.data.HttpRoutes
import com.ensegov.neofut.common.data.KtorClientApi
import com.ensegov.neofut.common.data.getWithToken
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine

class TopStatsApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) : KtorClientApi(engine, logging, tag = "api_call_goals") {

    suspend fun getTopScorers(leagueId: Int, season: Int): TopStatsResponse =
        client.getWithToken(
            url = "${HttpRoutes.TOP_SCORERS_REQUEST}?season=$season&league=$leagueId"
        ).body()

    suspend fun getTopAssists(leagueId: Int, season: Int): TopStatsResponse =
        client.getWithToken(
            url = "${HttpRoutes.TOP_ASSISTS_REQUEST}?season=$season&league=$leagueId"
        ).body()
}