package com.ensegov.neofut.common.data

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

open class KtorClientApi(
    engine: HttpClientEngine,
    logging: Boolean = false,
    tag: String = "api_call"
) {
    private val client = HttpClient(engine) {
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

    suspend fun request(url: String): HttpResponse =
        client.get(url) {
            header("x-rapidapi-key", HttpRoutes.API_TOKEN)
            header("x-rapidapi-host", HttpRoutes.API_HOST)
        }
}