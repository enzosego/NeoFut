package com.ensegov.neofut.competition_detail.data.local.fixture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface FixtureDao {

    @Insert
    fun insertAllRounds(vararg round: RoundName)

    @Query("SELECT name FROM round " +
            "WHERE :id = competition_id AND :season = season")
    fun getSeasonRounds(id: Int, season: Int): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMatches(vararg matchData: MatchData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTeams(vararg teamInfo: TeamInfo)

    @Transaction
    @Query("SELECT * FROM match_data " +
            "WHERE :id = competition_id AND :season = season AND :round = round")
    fun getMatchFixture(id: Int, season: Int, round: String): Flow<List<SimpleMatchFixture>>
}