package com.ensegov.neofut.data.local.model.fixture.round

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface RoundFixtureDataDao {

    @Query("SELECT * FROM round_fixture " +
            "WHERE :id = id AND :season = season AND :round = round")
    fun getMatches(id: Int, season: Int, round: String): Flow<RoundFixtureData>

    @Upsert
    fun upsert(roundFixtureData: RoundFixtureData)
}