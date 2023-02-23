package com.ensegov.neofut.ui.competition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.ui.competition.fixture.Fixture
import com.ensegov.neofut.ui.competition.fixture.RoundFixture
import com.ensegov.neofut.ui.competition.model.Competition
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun CupDetail(competition: Competition) {

    val viewModel: CompetitionDetailViewModel = koinViewModel()

    viewModel.setValues(competition)
    viewModel.getStandings()
    viewModel.getSeasonFixture()

    val standings by viewModel.standings.collectAsStateWithLifecycle()
    val roundList by viewModel.roundList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = competition.name,
            color = Color.Blue,
            fontSize = 30.sp
        )
        Fixture { roundList }
        GroupTable { standings }
    }
}