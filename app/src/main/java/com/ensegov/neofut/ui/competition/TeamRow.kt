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
import com.ensegov.neofut.data.remote.standings.dto.TeamPosition

@Composable
fun TeamRow(position: TeamPosition) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp)
    ) {
        Text(
            text = "${position.position}",
            fontSize = 23.sp,
            modifier = Modifier
                .width(30.dp),
        )
        Text(
            text = position.team.name,
            fontSize = 23.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(start = 8.dp)
        )
        Text(
            text = "${position.points}",
            fontSize = 23.sp,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
}
