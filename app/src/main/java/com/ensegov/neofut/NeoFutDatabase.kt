package com.ensegov.neofut

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ensegov.neofut.home.data.local.model.CompetitionData
import com.ensegov.neofut.home.data.local.CompetitionDataDao
import com.ensegov.neofut.home.data.local.model.SeasonData
import com.ensegov.neofut.competition_detail.data.local.team.TeamForm
import com.ensegov.neofut.competition_detail.data.local.standings.PositionInfo
import com.ensegov.neofut.competition_detail.data.local.standings.StandingsDao
import com.ensegov.neofut.competition_detail.data.local.team.TeamInfo
import com.ensegov.neofut.match_detail.data.local.fixture.FixtureDao
import com.ensegov.neofut.match_detail.data.local.fixture.MatchData
import com.ensegov.neofut.match_detail.data.local.fixture.RoundName
import com.ensegov.neofut.competition_detail.data.local.top_stats.StatsData
import com.ensegov.neofut.competition_detail.data.local.top_stats.TopStatsDao
import com.ensegov.neofut.competition_detail.data.local.player.PlayerData
import com.ensegov.neofut.competition_detail.data.local.team.VenueData
import com.ensegov.neofut.match_detail.data.local.fixture.MatchScoreData
import com.ensegov.neofut.update_times.data.local.UpdateTimeDao
import com.ensegov.neofut.update_times.data.local.UpdateTimeData

@Database(
    entities = [
        CompetitionData::class,
        SeasonData::class,
        RoundName::class,
        PositionInfo::class,
        TeamInfo::class,
        TeamForm::class,
        MatchData::class,
        MatchScoreData::class,
        VenueData::class,
        PlayerData::class,
        StatsData::class,
        UpdateTimeData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NeoFutDatabase : RoomDatabase() {

    abstract val standingsDao: StandingsDao
    abstract val competitionDao: CompetitionDataDao
    abstract val fixtureDao: FixtureDao
    abstract val topStatsDao: TopStatsDao
    abstract val updateTimeDao: UpdateTimeDao
}