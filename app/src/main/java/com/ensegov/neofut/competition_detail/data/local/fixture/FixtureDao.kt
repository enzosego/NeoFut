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
    fun insertAllRounds(roundList: List<RoundName>)

    @Query("SELECT * FROM round " +
            "WHERE :id = competition_id AND :season = season " +
            "ORDER BY `index`")
    fun getSeasonRounds(id: Int, season: Int): Flow<List<RoundName>>

    @Query("UPDATE round " +
            "SET current = 0 " +
            "WHERE current = 1 AND competition_id = :id AND season = :season")
    fun removeCurrentRound(id: Int, season: Int)

    @Query("UPDATE round " +
            "SET current = 1 " +
            "WHERE name = :roundName AND competition_id = :id AND season = :season")
    fun setCurrentRound(roundName: String, id: Int, season: Int)

    @Transaction
    fun updateCurrentRound(roundName: String, id: Int, season: Int) {
        removeCurrentRound(id, season)
        setCurrentRound(roundName, id, season)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMatches(matchList: List<MatchData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTeams(teamList: List<TeamInfo>)

    @Transaction
    @Query("SELECT * FROM match_data " +
            "WHERE :id = competition_id AND :season = season AND :round = round")
    fun getMatchFixture(id: Int, season: Int, round: String): List<SimpleMatchFixture>

    @Transaction
    suspend fun insertTeamsAndMatches(matchList: List<MatchData>, teamList: List<TeamInfo>) {
        insertAllMatches(matchList)
        insertAllTeams(teamList)
    }
}