package com.ensegov.neofut.competition_detail.data.local.team

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue")
data class VenueData(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "city")
    val city: String?,
    @ColumnInfo(name = "capacity")
    val capacity: Int?,
    @ColumnInfo(name = "image_url")
    val imageUrl: String?
)
