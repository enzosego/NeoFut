package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition

fun LazyListScope.groupTable(standings: () -> List<List<TeamPosition>>) {

    standings().forEach {
        item {
            Text(
                text = it[0].group,
                color = Color.Blue,
                fontSize = 30.sp
            )
        }
        items(it) { table ->
            TeamRow(table)
        }
    }
}