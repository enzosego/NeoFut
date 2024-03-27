package com.ensegov.neofut.match_detail.presentation.events

import androidx.compose.animation.AnimatedContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ensegov.neofut.common.presentation.model.UiState
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun EventsLayout(
    matchId: Int
) {
    val viewModel: EventsViewModel = koinViewModel(
        parameters = { parametersOf(matchId) }
    )
    val events by viewModel.events.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = uiState,
        label = "animatedEventsLayout"
    ) { state ->
        when (state) {
            is UiState.Loading -> Text(text = "")
            is UiState.Success -> EventsSuccessLayout({ events })
            is UiState.Error -> Text(text = "")
        }
    }
}