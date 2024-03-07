package com.ensegov.neofut.home.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.ensegov.neofut.home.data.local.model.CompetitionData
import com.ensegov.neofut.home.data.local.model.SeasonData

@Dao
interface CompetitionDataDao {

    @Query("SELECT * FROM competition_data " +
            "JOIN season ON competition_data.id = season.competition_id")
    fun getAll(): Map<CompetitionData, List<SeasonData>>

    @Upsert
    fun insertAllCompetitions(competitionData: List<CompetitionData>)

    @Insert
    fun insertAllSeasons(seasonData: List<SeasonData>)

    @Transaction
    suspend fun insertCompetitionWithSeasons(
        competitionList: List<CompetitionData>,
        seasonList: List<SeasonData>
    ) {
        insertAllCompetitions(competitionList)
        insertAllSeasons(seasonList)
    }
}