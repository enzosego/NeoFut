package com.ensegov.neofut.data.remote.utils

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClientBuilder(
    engine: HttpClientEngine = Android.create(),
    isLoggingEnabled: Boolean = false,
    tag: String = "api_call"
) {
    val client = HttpClient(engine) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        if (isLoggingEnabled)
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