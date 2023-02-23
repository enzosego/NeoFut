package com.ensegov.neofut.data.local.converters

import androidx.room.TypeConverter
import com.ensegov.neofut.data.remote.competition.dto.Country
import com.ensegov.neofut.data.remote.competition.dto.season.Season
import com.ensegov.neofut.data.remote.fixture.dto.MatchFixture
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object RoomConverters {

    // Standings list
    @TypeConverter
    fun toGroupListJson(list: List<List<TeamPosition>>): String =
        Json.encodeToString(list)

    @TypeConverter
    fun fromGroupListJson(json: String): List<List<TeamPosition>> =
        Json.decodeFromString(json)

    // Season list
    @TypeConverter
    fun toSeasonListJson(list: List<Season>): String =
        Json.encodeToString(list)

    @TypeConverter
    fun fromSeasonListJson(json: String): List<Season> =
        Json.decodeFromString(json)

    // Country
    @TypeConverter
    fun toCountryJson(country: Country): String =
        Json.encodeToString(country)

    @TypeConverter
    fun fromCountryJson(json: String): Country =
        Json.decodeFromString(json)

    // String list
    @TypeConverter
    fun toStringListJson(list: List<String>): String =
        Json.encodeToString(list)

    @TypeConverter
    fun fromStringListJson(json: String): List<String> =
        Json.decodeFromString(json)

    // MatchFixture list
    @TypeConverter
    fun toMatchListJson(list: List<MatchFixture>): String =
        Json.encodeToString(list)

    @TypeConverter
    fun fromMatchListJson(json: String): List<MatchFixture> =
        Json.decodeFromString(json)
}