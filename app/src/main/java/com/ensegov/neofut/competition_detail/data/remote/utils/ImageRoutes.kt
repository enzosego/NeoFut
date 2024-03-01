package com.ensegov.neofut.competition_detail.data.remote.utils

object ImageRoutes {

    private const val BASE_URL = "https://media.api-sports.io/football"

    fun leagueRequest(leagueId: Int) = "$BASE_URL/leagues/$leagueId.png"
}