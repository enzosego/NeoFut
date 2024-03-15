package com.ensegov.neofut.competition_detail.data.repository

import com.ensegov.neofut.competition_detail.createFakeRoundFixture
import com.ensegov.neofut.match_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepository
import com.ensegov.neofut.competition_detail.presentation.fixture.model.MatchDay
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeFixtureRepository(
    private val hasPersistedSeasonFixture: Boolean = false,
    private val hasPersistedRoundFixture: Boolean = false,
    private val canUpdateRoundFixture: Boolean = true,
    private var currentRoundIndex: Int = 0
) : FixtureRepository {

    private val seasonRounds = MutableStateFlow(
        if (hasPersistedSeasonFixture)
            createFakeSeasonFixture()
        else
            emptyList()
    )

    override suspend fun updateSeasonRounds(id: Int, season: Int) {
        updateCurrentRound(128, 2024)
        seasonRounds.update { createFakeSeasonFixture() }
    }

    override fun getSeasonRounds(id: Int, season: Int): Flow<List<RoundName>> =
        seasonRounds

    override suspend fun updateCurrentRound(id: Int, season: Int) {
        currentRoundIndex = 13
    }

    override suspend fun updateRoundFixture(id: Int, season: Int, round: String): List<MatchDay> {
        delay(300L)
        return createFakeRoundFixture(12)
    }

    override suspend fun getRoundFixture(id: Int, season: Int, round: String): List<MatchDay> =
        if (hasPersistedRoundFixture)
            createFakeRoundFixture(8)
        else
            emptyList()

    override suspend fun canUpdateSeasonRounds(id: Int, season: Int): Boolean =
        !hasPersistedSeasonFixture

    override suspend fun canUpdateCurrentRound(id: Int, season: Int): Boolean = true

    override suspend fun canUpdateRoundFixture(id: Int, season: Int, round: String): Boolean =
        canUpdateRoundFixture

    private fun createFakeSeasonFixture() =
        List(size = 14) {
            RoundName(
                competitionId = 128,
                index = it,
                name = "round - $it",
                season = 2024,
                current = it == currentRoundIndex
            )
        }
}