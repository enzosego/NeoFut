package com.ensegov.neofut.data.local.converters

import androidx.room.TypeConverter
import com.ensegov.neofut.data.remote.competition.dto.standings.Standings
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object StandingsConverters {

    @TypeConverter
    fun toStandingsJson(standings: List<Standings>): String =
        Json.encodeToString(standings)

    @TypeConverter
    fun fromStandingsJson(json: String): List<Standings> =
        Json.decodeFromString(json)
}