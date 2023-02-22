package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition

@Composable
fun GroupTable(standings: () -> List<List<TeamPosition>>) {

    LazyColumn(
        modifier = Modifier
            .padding(20.dp)
    ) {
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
}