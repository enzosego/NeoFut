package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionDataDao {

    @Query("SELECT * FROM competition_data")
    fun getAll(): Flow<List<CompetitionData>>

    @Upsert
    fun upsertAll(vararg competitionData: CompetitionData)
}