package com.ensegov.neofut.match_detail.data.local.fixture

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.competition_detail.data.local.team.VenueData
import kotlinx.coroutines.flow.Flow

@Dao
interface FixtureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
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

    @Transaction
    @Query("SELECT * FROM match_data " +
            "WHERE :id = competition_id AND :season = season AND :round = round")
    fun getRoundFixture(id: Int, season: Int, round: String): Flow<List<SimpleMatchFixture>>

    @Transaction
    @Query("SELECT * FROM match_data " +
            "WHERE :matchId = id")
    fun getFullMatchFixture(matchId: Int): Flow<FullMatchFixture?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMatches(matchList: List<MatchData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTeams(teamList: List<TeamInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertScores(scoreList: List<MatchScoreData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVenues(venueList: List<VenueData>)

    @Transaction
    suspend fun insertAllFixtureData(
        matchList: List<MatchData>,
        scoreList: List<MatchScoreData>,
        teamList: List<TeamInfo>,
        venueList: List<VenueData>
    ) {
        insertAllMatches(matchList)
        insertScores(scoreList)
        insertAllTeams(teamList)
        insertVenues(venueList)
    }
}