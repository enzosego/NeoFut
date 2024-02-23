package com.ensegov.neofut.data.repository

import com.ensegov.neofut.data.remote.competition.dto.Country
import com.ensegov.neofut.data.repository.competitions.CompetitionsRepository
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeCompetitionsRepository : CompetitionsRepository {

    private val fakeDatabase = MutableStateFlow(emptyList<Competition>())

    override suspend fun fetchAllCompetitions(countryName: String) {
        val newList = mutableListOf<Competition>()
        ('a'..'z').forEachIndexed { index, char ->
            newList.add(
                Competition(
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

        fakeDatabase.emit(newList)
    }

    override suspend fun getAllCompetitions(): Flow<List<Competition>> = fakeDatabase
}