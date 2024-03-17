package com.ensegov.neofut.match_detail.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Destination
@Composable
fun MatchDetailScreen(
    matchId: Int,
    modifier: Modifier = Modifier
) {

    val viewModel: MatchDetailViewModel = koinViewModel(
        parameters = { parametersOf(matchId) }
    )
    val matchDetail by viewModel.matchDetail.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        AnimatedVisibility(visible = matchDetail != null) {
            Text(
                text = "${matchDetail?.homeTeam?.name} - ${matchDetail?.awayTeam?.name}",
                fontSize = 24.sp
            )
        }
    }
}