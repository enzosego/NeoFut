package com.ensegov.neofut.data.local.model.fixture

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SeasonFixtureDataDao {

    @Query("SELECT * FROM fixture_data " +
            "WHERE :id = id AND :season = season")
    fun getMatch(id: Int, season: Int): Flow<SeasonFixtureData>

    @Upsert
    fun upsert(seasonFixtureData: SeasonFixtureData)
}