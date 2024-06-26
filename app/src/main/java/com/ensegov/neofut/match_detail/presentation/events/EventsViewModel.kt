package com.ensegov.neofut.match_detail.presentation.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.match_detail.data.repository.events.EventsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventsViewModel(
    private val eventsRepository: EventsRepository,
    private val matchId: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<Boolean>>(UiState.Success(data = false))
    val uiState = _uiState.asStateFlow()

    val events = flow {
        emitAll(eventsRepository.getEvents(matchId))
    }
        .onEach {
            if (it.isEmpty()) updateEvents()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = emptyList()
        )

    private fun updateEvents() = viewModelScope.launch {
        _uiState.update { UiState.Loading }
        _uiState.update {
            try {
                eventsRepository.updateEvents(matchId)
                UiState.Success(data = false)
            } catch (e: Exception) {
                UiState.Error(e.message ?: "")
            }
        }
    }

    companion object {
        const val TIMEOUT_MILLIS = 5000L
    }
}