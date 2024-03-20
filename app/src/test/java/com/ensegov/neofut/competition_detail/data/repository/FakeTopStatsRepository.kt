package com.ensegov.neofut.competition_detail.data.repository

import com.ensegov.neofut.competition_detail.data.repository.top_stats.TopStatsRepository
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerStatsUiData
import com.ensegov.neofut.competition_detail.presentation.player_stats.model.PlayerUiData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeTopStatsRepository(
    hasPersistedData: Boolean,
    private val canUpdate: Boolean,
    private val networkError: Boolean
) : TopStatsRepository {

    private val topScorers = MutableStateFlow(
        if (hasPersistedData)
            getFakeTopStats("goals")
        else
            emptyList()
    )
    private val topAssists = MutableStateFlow(
        if (hasPersistedData)
            getFakeTopStats("assists")
        else
            emptyList()
    )

    override fun getTopScorers(competitionId: Int, season: Int): Flow<List<PlayerStatsUiData>> =
        topScorers

    override suspend fun updateTopScorers(competitionId: Int, season: Int) {
        delay(300L)
        if (networkError)
            throw Exception()
        else
            topScorers.update { getFakeTopStats(type = "goals", count = 3) }
    }

    override fun getTopAssists(competitionId: Int, season: Int): Flow<List<PlayerStatsUiData>> =
        topAssists

    override suspend fun updateTopAssists(competitionId: Int, season: Int) {
        delay(300L)
        if (networkError)
            throw Exception()
        else
            topAssists.update { getFakeTopStats(type = "assists", count = 3) }
    }

    override suspend fun canUpdateTopStats(type: String, id: Int, season: Int): Boolean =
        canUpdate
}

fun getFakeTopStats(type: String, count: Int = 2) =
    List(count) {
        PlayerStatsUiData(
            player = PlayerUiData(
                name = "$type $it",
                firstName = "",
                lastName = "",
                photoUrl = ""
            ),
            position = it,
            totalGoals = it * 2,
            penaltyGoals = it,
            assists =  it,
            teamName = "",
            teamLogoUrl = ""
        )
    }