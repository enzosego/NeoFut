package com.ensegov.neofut.data.remote.fixture

import com.ensegov.neofut.data.remote.fixture.dto.Rounds
import com.ensegov.neofut.data.remote.utils.HttpRoutes
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*

class FixtureApi(engine: HttpClientEngine = Android.create()) {

    private val client = KtorClientBuilder(engine).client

    suspend fun getRounds(leagueId: Int, season: Int): Rounds =
        client.getWithToken(
            "${HttpRoutes.FIXTURE_REQUEST}/rounds?league=$leagueId&season=$season"
        ).body()
}