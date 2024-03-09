package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.fixture.RoundFixture
import com.ensegov.neofut.competition_detail.data.local.fixture.RoundName
import com.ensegov.neofut.data.local.model.fixture.season.SeasonFixtureData
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.AllMatchScores
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchInfo
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchScore
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchStatus
import com.ensegov.neofut.competition_detail.data.remote.fixture.dto.match.MatchTeams
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.FormStats
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.GoalStats
import com.ensegov.neofut.competition_detail.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.competition_detail.data.remote.team.Team
import com.ensegov.neofut.competition_detail.data.remote.team.Venue
import com.ensegov.neofut.competition_detail.data.repository.fixture.FixtureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

class FakeCompetitionDetailRepository : FixtureRepository {

    /**
     * Standings
     */
    private val fakeStandingsDatabase = MutableStateFlow(
        listOf(
            CompetitionStandings(2, 2022, createFakeList()),
            CompetitionStandings(39, 2021, createFakeList())
        )
    )

    override suspend fun updateStandings(id: Int, season: Int) {
        val newStandings = CompetitionStandings(id, season, createFakeList())
        val newData = fakeStandingsDatabase.first().toMutableList() + newStandings

        fakeStandingsDatabase.emit(newData)
    }

    override fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?> =
        callbackFlow {
            fakeStandingsDatabase.collectValue(Dispatchers.Main) { newData ->
                val newValue = newData.find { it.id == id && it.seasonNum == season }
                send(newValue)
            }
            awaitClose()
        }

    private fun createFakeList(): List<List<TeamPosition>> {
        val newList = mutableListOf<List<TeamPosition>>()
        repeat(3) {
            val subList = mutableListOf<TeamPosition>()

            ('a'..'e').forEachIndexed { i, char ->
                val c = char.toString()
                subList.add(
                    TeamPosition(
                        i, Team(i, c, c, ""),
                        i, i, c, c, c, c,
                        createFormStats(i),
                        createFormStats(i),
                        createFormStats(i)
                    )
                )
            }
            newList.add(subList)
        }
        return newList
    }

    private fun createFormStats(i: Int) =
        FormStats(i, i, i, i, GoalStats(i, i))

    /**
     * Season RoundFixture
     */
    private val fakeRoundsDatabase = MutableStateFlow(
        listOf(
            RoundName(2, 2024, "Round 1"),
            RoundName(2, 2024, "Round 2"),
            RoundName(128, 2024, "Round 1"),
            RoundName(128, 2024, "Round 2")
            SeasonFixtureData(2, 2022, createRoundList(48)),
            SeasonFixtureData(128, 2022, createRoundList(28))
        )
    )

    override suspend fun updateSeasonFixture(id: Int, season: Int) {
        val newFixture = SeasonFixtureData(id, season, createRoundList(38))

        val oldData = fakeRoundsDatabase.first().toMutableList()
        val newData = oldData + newFixture

        fakeRoundsDatabase.emit(newData)
    }

    override fun getSeasonFixture(id: Int, season: Int): Flow<SeasonFixtureData?> =
        callbackFlow {
            fakeRoundsDatabase.collectValue(Dispatchers.Main) { newData ->
                val newValue = newData.find { it.id == id && it.season == season }
                send(newValue)
            }
            awaitClose()
        }

    private fun createRoundList(num: Int): List<String> {
        val list = mutableListOf<String>()
        repeat(num) {
            list.add("$it")
        }
        return list
    }

    /**
     * Round RoundFixture
     */
    private val fakeMatchFixtureDatabase = MutableStateFlow(
        listOf(
            RoundFixture(2, 2021, "Preliminary Round", createFakeMatchList()),
            RoundFixture(39, 2022, "Regular Season - 3", createFakeMatchList()),
        )
    )

    override suspend fun updateRoundFixture(id: Int, season: Int, round: String) {
        val newFixture = RoundFixture(id, season, round, createFakeMatchList())
        fakeMatchFixtureDatabase.update { it + newFixture }
    }

    override suspend fun getRoundFixture(id: Int, season: Int, round: String): Flow<RoundFixture?> =
        callbackFlow {
            fakeMatchFixtureDatabase.collectValue(Dispatchers.Main) { newData ->
                send(
                    newData.find { it.id == id && it.season == season && it.round == round }
                )
            }
            awaitClose()
        }

    private fun createFakeMatchList(): List<MatchFixture> {
        val fakeList = mutableListOf<MatchFixture>()
        repeat(10) {
            val itS = it.toString()
            val newMatch = MatchFixture(
                MatchInfo(it, itS, itS, itS, Venue(it, itS, itS), MatchStatus(itS, itS, it)),
                MatchTeams(Team(it, itS, itS, itS, it, false), Team(it, itS, itS, itS, it, true)),
                MatchScore(it, it),
                AllMatchScores(
                    MatchScore(it, it), MatchScore(it, it), MatchScore(it, it), MatchScore(it, it)
                )
            )
            fakeList.add(newMatch)
        }
        return fakeList
    }
}