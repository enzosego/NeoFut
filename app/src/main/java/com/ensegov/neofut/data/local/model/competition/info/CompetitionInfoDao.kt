package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionInfoDao {

    @Query("SELECT * FROM competition_info")
    fun getAll(): Flow<List<CompetitionInfo>>

    @Upsert
    fun insertOrUpdateAll(vararg competitionInfo: CompetitionInfo)
}