package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.remote.standings.dto.FormStats
import com.ensegov.neofut.data.remote.standings.dto.GoalStats
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import com.ensegov.neofut.data.remote.team.dto.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow

class FakeCompetitionDetailRepository : CompetitionDetailRepository {

    private val fakeList = MutableStateFlow(emptyList<List<TeamPosition>>())

    override val currentStandings: Flow<List<List<TeamPosition>>> = callbackFlow {
        fakeList.collectValue(Dispatchers.Main) { list ->
            send(list)
        }
        awaitClose()
    }

    override suspend fun getStandings(id: Int, season: Int) {
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
        delay(1000L)

        fakeList.emit(newList)
    }

    private fun createFormStats(i: Int) =
        FormStats(i, i, i, i, GoalStats(i, i))
}