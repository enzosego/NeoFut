package com.ensegov.neofut.competition_detail.presentation.standings

import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.data.repository.FakeStandingsRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.scopes.StringSpecScope
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

private const val TAG = "StandingsViewModelTest"

@OptIn(ExperimentalCoroutinesApi::class)
class StandingsViewModelTest : StringSpec({

    coroutineTestScope = true

    beforeTest { Dispatchers.setMain(StandardTestDispatcher(TestCoroutineScheduler())) }

    afterTest { Dispatchers.resetMain() }

    "$TAG - ViewModel initialization - correct State values" {
        val standingsViewModel = getViewModel(FakeStandingsRepository())
        observeValue(standingsViewModel.standings) { value shouldBe emptyList() }
        observeValue(standingsViewModel.uiState) { value shouldBe UiState.Success(data = false) }
    }

    "$TAG - has persisted data - cannot update - retrieves from database" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(
                hasPersistedData = true,
                canUpdate = false
            )
        )
        observeValue(standingsViewModel.standings) {
            delay(500L)
            value.size shouldBe 3
        }
    }

    "$TAG - has persisted data - can update - retrieves then updates from network" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(hasPersistedData = true)
        )
        observeValue(standingsViewModel.standings) {
            delay(100L)
            value.size shouldBe 3
            delay(500L)
            value.size shouldBe 5
        }
    }

    "$TAG - has persisted data - can update - retrieves and network request fails" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(
                hasPersistedData = true,
                requestFailure = true
            )
        )
        observeValue(standingsViewModel.standings) {
            delay(500L)
            value.size shouldBe 3
        }
    }

    "$TAG - no persisted data - makes request from network" {
        val standingsViewModel = getViewModel(FakeStandingsRepository())
        observeValue(standingsViewModel.standings) {
            delay(500L)
            value.size shouldBe 5
        }
    }

    "$TAG - no persisted data - network request fails" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(requestFailure = true)
        )
        val job = launch { standingsViewModel.standings.collect() }
        observeValue(standingsViewModel.uiState) {
            delay(500L)
            value shouldBe UiState.Error("")
            job.cancel()
        }
    }
})

suspend fun <T> StringSpecScope.observeValue(
    value: StateFlow<T>,
    assert: suspend StateFlow<T>.() -> Unit
) {
    val job = launch { value.collect() }

    assert(value)

    job.cancel()
}

private fun getViewModel(repository: FakeStandingsRepository) =
    StandingsViewModel(
        standingsRepository = repository,
        id = 1,
        season = 2024
    )