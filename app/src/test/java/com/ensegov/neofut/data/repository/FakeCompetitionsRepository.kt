package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.local.model.competition.info.CompetitionData
import com.ensegov.neofut.data.remote.competition.dto.Country
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow

class FakeCompetitionsRepository : CompetitionsRepository {

    private val fakeList = MutableStateFlow(emptyList<CompetitionData>())

    override val allCompetitions: Flow<List<CompetitionData>> = callbackFlow {
        fakeList.collectValue(Dispatchers.Main) { list ->
            send(list)
        }
        awaitClose()
    }

    override suspend fun getAllCompetitions() {
        val newList = mutableListOf<CompetitionData>()
        ('a'..'z').forEachIndexed { index, char ->
            newList.add(
                CompetitionData(
                    index,
                    char.toString(),
                    char.toString(),
                    "https://www.fakeimage.com/$char",
                    Country(char.toString(), null, char.toString()),
                    emptyList()
                )
            )
        }
        delay(1000L)
        fakeList.emit(newList)
    }
}