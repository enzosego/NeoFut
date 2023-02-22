package com.ensegov.neofut.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ensegov.neofut.data.local.converters.RoomConverters
import com.ensegov.neofut.data.local.model.competition.info.CompetitionData
import com.ensegov.neofut.data.local.model.competition.info.CompetitionDataDao
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandings
import com.ensegov.neofut.data.local.model.competition.standings.CompetitionStandingsDao
import com.ensegov.neofut.data.local.model.fixture.SeasonFixtureData
import com.ensegov.neofut.data.local.model.fixture.SeasonFixtureDataDao

@Database(
    entities = [
        CompetitionStandings::class,
        CompetitionData::class,
        SeasonFixtureData::class
               ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomConverters::class)
abstract class NeoFutDatabase : RoomDatabase() {

    abstract val standingsDao: CompetitionStandingsDao
    abstract val competitionDao: CompetitionDataDao
    abstract val seasonFixtureDao: SeasonFixtureDataDao
}