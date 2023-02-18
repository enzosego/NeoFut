package com.ensegov.neofut.data.local.converters

import androidx.room.TypeConverter
import com.ensegov.neofut.data.remote.competition.dto.Country
import com.ensegov.neofut.data.remote.competition.dto.season.Season
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object RoomConverters {

    // CompetitionDto Standings
    @TypeConverter
    fun toGroupListJson(groupList: List<List<TeamPosition>>): String =
        Json.encodeToString(groupList)

    @TypeConverter
    fun fromGroupListJson(json: String): List<List<TeamPosition>> =
        Json.decodeFromString(json)

    // Season list
    @TypeConverter
    fun toSeasonListJson(seasonList: List<Season>): String =
        Json.encodeToString(seasonList)

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
}