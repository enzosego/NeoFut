package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.data.remote.competition.dto.standings.TeamPosition

@Composable
fun TeamRow(team: TeamPosition) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp)
    ) {
        Text(
            text = "${team.position}",
            fontSize = 23.sp,
            modifier = Modifier
                .width(30.dp),
        )
        Text(
            text = team.team.shortName,
            fontSize = 23.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = "${team.points}",
            fontSize = 23.sp,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}
