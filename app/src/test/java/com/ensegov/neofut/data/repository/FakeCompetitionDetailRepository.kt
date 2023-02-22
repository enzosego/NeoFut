package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.fixture.SeasonFixtureData
import com.ensegov.neofut.data.remote.standings.dto.FormStats
import com.ensegov.neofut.data.remote.standings.dto.GoalStats
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

class FakeCompetitionDetailRepository : CompetitionDetailRepository {

    private val fakeStandingsDatabase = MutableStateFlow(
        listOf(
            CompetitionStandings(2, 2022, createFakeList()),
            CompetitionStandings(39, 2021, createFakeList())
        )
    )

    override suspend fun updateStandings(id: Int, season: Int) {
        val newStandings = CompetitionStandings(id, season, createFakeList())
        val newData = fakeStandingsDatabase.first().toMutableList() + newStandings

        newData.forEach { println("Id: ${it.id} - Season: ${it.seasonNum}") }

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
                        i, Team(i, c, c),
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

    private val fakeFixtureDatabase = MutableStateFlow(
        listOf(
            SeasonFixtureData(2, 2022, createRoundList(48)),
            SeasonFixtureData(128, 2022, createRoundList(28))
        )
    )

    override suspend fun updateSeasonFixture(id: Int, season: Int) {
        val newFixture = SeasonFixtureData(id, season, createRoundList(38))

        val oldData = fakeFixtureDatabase.first().toMutableList()
        val newData = oldData + newFixture

        fakeFixtureDatabase.emit(newData)
    }

    override fun getSeasonFixture(id: Int, season: Int): Flow<SeasonFixtureData?> =
        callbackFlow {
            fakeFixtureDatabase.collectValue(Dispatchers.Main) { newData ->
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
}