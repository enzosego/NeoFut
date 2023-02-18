package com.ensegov.neofut.data.remote.utils

object ImageRoutes {

    private const val BASE_URL = "https://media.api-sports.io/football"

    fun leagueRequest(leagueId: Int) = "$BASE_URL/leagues/$leagueId.png"
}