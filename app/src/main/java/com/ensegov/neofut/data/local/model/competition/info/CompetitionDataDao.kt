package com.ensegov.neofut.data.local.model.competition.info

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionDataDao {

    @Query("SELECT * FROM competition_data " +
            "JOIN season ON competition_data.id = season.competition_id")
    fun getAll(): Flow<Map<CompetitionData, List<SeasonData>>>

    @Upsert
    fun insertAllCompetitions(vararg competitionData: CompetitionData)

    @Insert
    fun insertAllSeasons(vararg seasonData: SeasonData)
}