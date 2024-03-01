package com.ensegov.neofut.competition_detail.data.remote.utils

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClientBuilder(
    engine: HttpClientEngine,
    logging: Boolean = false,
    tag: String = "api_call"
) {
    val client = HttpClient(engine) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        if (logging)
            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d(tag, message)
                    }
                }
            }
    }
}