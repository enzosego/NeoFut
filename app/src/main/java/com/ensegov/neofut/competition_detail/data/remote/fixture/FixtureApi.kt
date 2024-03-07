package com.ensegov.neofut.competition_detail.data.remote.fixture

import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.FixtureResponse
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.SeasonRounds
import com.ensegov.neofut.common.data.HttpRoutes
import com.ensegov.neofut.common.data.KtorClientApi
import com.ensegov.neofut.common.data.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*

class FixtureApi(
    engine: HttpClientEngine,
    logging: Boolean = true
) : KtorClientApi(engine, logging, tag = "api_call_fixture") {

    suspend fun getRounds(leagueId: Int, season: Int): SeasonRounds =
        client.getWithToken(
            "${HttpRoutes.FIXTURE_REQUEST}/rounds?league=$leagueId&season=$season"
        ).body()

    suspend fun getFixture(leagueId: Int, season: Int, round: String): FixtureResponse =
        client.getWithToken(
            "${HttpRoutes.FIXTURE_REQUEST}?league=$leagueId&season=$season&round=$round"
        ).body()
}