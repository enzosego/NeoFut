package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.remote.standings.dto.FormStats
import com.ensegov.neofut.data.remote.standings.dto.GoalStats
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class FakeCompetitionDetailRepository : CompetitionDetailRepository {

    private val fakeDatabase = MutableStateFlow(
        listOf(
            CompetitionStandings(2, 2022, createFakeList()),
            CompetitionStandings(39, 2021, createFakeList())
        )
    )

    override suspend fun updateStandings(id: Int, season: Int) {
        val newStandings = CompetitionStandings(id, season, createFakeList())
        val newData = fakeDatabase.first().toMutableList() + newStandings

        delay(1000L)
        newData.forEach { println("Id: ${it.id} - Season: ${it.seasonNum}") }

        fakeDatabase.emit(newData)
    }

    override fun getStandings(id: Int, season: Int): Flow<CompetitionStandings?> =
        callbackFlow {
            fakeDatabase.collectValue(Dispatchers.Main) { newData ->
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
}