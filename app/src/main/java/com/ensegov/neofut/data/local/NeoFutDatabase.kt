package com.ensegov.neofut.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ensegov.neofut.data.local.model.competition.info.CompetitionData
import com.ensegov.neofut.data.local.model.competition.info.CompetitionDataDao
import com.ensegov.neofut.data.local.model.competition.info.SeasonData
import com.ensegov.neofut.data.local.model.competition.standings.TeamForm
import com.ensegov.neofut.data.local.model.competition.standings.PositionInfo
import com.ensegov.neofut.data.local.model.competition.standings.StandingsDao
import com.ensegov.neofut.data.local.model.competition.standings.TeamInfo
import com.ensegov.neofut.data.local.model.fixture.FixtureDao
import com.ensegov.neofut.data.local.model.fixture.MatchData
import com.ensegov.neofut.data.local.model.fixture.RoundName

@Database(
    entities = [
        CompetitionData::class,
        SeasonData::class,
        RoundName::class,
        PositionInfo::class,
        TeamInfo::class,
        TeamForm::class,
        MatchData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class NeoFutDatabase : RoomDatabase() {

    abstract val standingsDao: StandingsDao
    abstract val competitionDao: CompetitionDataDao
    abstract val fixtureDao: FixtureDao
}