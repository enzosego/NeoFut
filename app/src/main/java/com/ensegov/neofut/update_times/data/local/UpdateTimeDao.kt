package com.ensegov.neofut.update_times.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface UpdateTimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTime(timeData: UpdateTimeData)

    @Query("SELECT * FROM update_time " +
            "WHERE :type = type AND :competitionId = competition_id AND :season = season " +
            "AND :roundName = round_name")
    fun getLastUpdateTime(
        type: String,
        competitionId: Int,
        season: Int,
        roundName: String = ""
    ): UpdateTimeData?
}