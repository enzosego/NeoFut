package com.ensegov.neofut.competition_detail.presentation.standings

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.ensegov.neofut.competition_detail.presentation.standings.model.CompetitionGroup

fun LazyListScope.groupTable(standings: () -> List<CompetitionGroup>) {

    standings().forEach { group ->
        item {
            Text(
                text = group.groupName,
                color = Color.Blue,
                fontSize = 30.sp
            )
        }
        items(group.teamList) { team ->
            TeamRow(team)
        }
    }
}