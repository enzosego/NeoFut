package com.ensegov.neofut.data.remote.team

import com.ensegov.neofut.data.remote.team.dto.Team
import com.ensegov.neofut.data.remote.utils.KtorClientBuilder
import com.ensegov.neofut.data.remote.utils.getWithToken
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*

class TeamsApi(engine: HttpClientEngine) {

    private val client = KtorClientBuilder(
        engine,
        logging = true
    ).client

    suspend fun getTeam(teamId: String): Team =
        client.getWithToken(teamId)
            .body()
}