package com.ensegov.neofut.match_detail.presentation.events

import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.presentation.standings.observeValue
import com.ensegov.neofut.match_detail.data.remote.repository.events.FakeEventsRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

const val TAG = "EventsViewModel"

@OptIn(ExperimentalCoroutinesApi::class)
class EventsViewModelTest : StringSpec({

    coroutineTestScope = true

    beforeTest { Dispatchers.setMain(StandardTestDispatcher(TestCoroutineScheduler())) }

    afterTest { Dispatchers.resetMain() }

    "$TAG - viewModel initialization - empty state" {
        val eventsViewModel = getViewModel()
        observeValue(eventsViewModel.events) { value.size shouldBe 0 }
    }

    "$TAG - has persisted data - retrieves from database" {
        val eventsViewModel = getViewModel(persistedData = true)
        observeValue(eventsViewModel.events) {
            delay(500L)
            value.size shouldBe 7
        }
    }

    "$TAG - no persisted data - fetches from network" {
        val eventsViewModel = getViewModel()
        observeValue(eventsViewModel.events) {
            delay(500L)
            value.size shouldBe 12
        }
    }

    "$TAG - uiState gets updated correctly throughout lifecycle" {
        val eventsViewModel = getViewModel()
        val job = launch { eventsViewModel.events.collect() }
        observeValue(eventsViewModel.uiState) {
            value shouldBe UiState.Success(data = false)
            delay(100L)
            value shouldBe UiState.Loading
            delay(400L)
            value shouldBe UiState.Success(data = false)

            job.cancel()
        }
    }

    "$TAG - network error - uiState is UiState.Error" {
        val eventsViewModel = getViewModel(networkError = true)
        val job = launch { eventsViewModel.events.collect() }
        observeValue(eventsViewModel.uiState) {
            delay(500L)
            value shouldBe UiState.Error(message = "")

            job.cancel()
        }
    }
})

private fun getViewModel(
    persistedData: Boolean = false,
    networkError: Boolean = false
) =
    EventsViewModel(
        FakeEventsRepository(persistedData, networkError),
        matchId = 0
    )