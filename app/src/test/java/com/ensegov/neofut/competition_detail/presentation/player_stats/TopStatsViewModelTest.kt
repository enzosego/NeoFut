package com.ensegov.neofut.competition_detail.presentation.player_stats

import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.data.repository.FakeTopStatsRepository
import com.ensegov.neofut.competition_detail.data.repository.getFakeTopStats
import com.ensegov.neofut.competition_detail.presentation.standings.observeValue
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

const val TAG = "TopStatsViewModelTest"

@OptIn(ExperimentalCoroutinesApi::class)
class TopStatsViewModelTest : StringSpec({

    coroutineTestScope = true

    beforeTest { Dispatchers.setMain(StandardTestDispatcher(TestCoroutineScheduler())) }

    afterTest { Dispatchers.resetMain() }

    "$TAG viewModel initialization - correct State values" {
        val topStatsViewModel = getViewModel(type = "goals")
        observeValue(topStatsViewModel.playerStats) { value shouldBe emptyList() }
        observeValue(topStatsViewModel.uiState) { value shouldBe UiState.Success(data = false) }
    }

    "$TAG topScorers, has persisted data - cannot update - retrieves from database" {
        val topStatsViewModel = getViewModel(
            type = "goals",
            persistedData = true,
            canUpdate = false
        )
        observeValue(topStatsViewModel.playerStats) {
            delay(500L)
            value shouldBe getFakeTopStats(type = "goals")
        }
    }

    "$TAG topAssists, has persisted data - cannot update - retrieves from database" {
        val topStatsViewModel = getViewModel(
            type = "assists",
            persistedData = true,
            canUpdate = false
        )
        observeValue(topStatsViewModel.playerStats) {
            delay(500L)
            value shouldBe getFakeTopStats(type = "assists")
        }
    }

    "$TAG topScorers, has persisted data - can update - retrieves then fetches from network" {
        val topStatsViewModel = getViewModel(
            type = "goals",
            persistedData = true
        )

        observeValue(topStatsViewModel.playerStats) {
            delay(100L)
            value shouldBe getFakeTopStats(type = "goals")

            delay(400L)
            value shouldBe getFakeTopStats(type = "goals", count = 3)
        }
    }

    "$TAG topAssists, has persisted data - can update - retrieves then fetches from network" {
        val topStatsViewModel = getViewModel(
            type = "assists",
            persistedData = true
        )

        observeValue(topStatsViewModel.playerStats) {
            delay(100L)
            value shouldBe getFakeTopStats(type = "assists")

            delay(400L)
            value shouldBe getFakeTopStats(type = "assists", count = 3)
        }
    }

    "$TAG topScorers, no persisted data - fetches from network" {
        val viewModel = getViewModel(type = "goals")
        observeValue(viewModel.playerStats) {
            delay(100L)
            value shouldBe emptyList()

            delay(400L)
            value shouldBe getFakeTopStats(type = "goals", count = 3)
        }
    }

    "$TAG topAssists, no persisted data - fetches from network" {
        val viewModel = getViewModel(type = "assists")
        observeValue(viewModel.playerStats) {
            delay(100L)
            value shouldBe emptyList()

            delay(400L)
            value shouldBe getFakeTopStats(type = "assists", count = 3)
        }
    }

    "$TAG topScorers, no persisted data - network request fails" {
        val viewModel  = getViewModel(type = "goals", networkError = true)
        val job = launch { viewModel.playerStats.collect() }
        observeValue(viewModel.uiState) {
            delay(500L)
            value shouldBe UiState.Error("")
            job.cancel()
        }
    }

    "$TAG topAssists, no persisted data - network request fails" {
        val viewModel  = getViewModel(type = "assists", networkError = true)
        val job = launch { viewModel.playerStats.collect() }
        observeValue(viewModel.uiState) {
            delay(500L)
            value shouldBe UiState.Error("")
            job.cancel()
        }
    }
})

private fun getViewModel(
    type: String,
    persistedData: Boolean = false,
    canUpdate: Boolean = true,
    networkError: Boolean = false
) =
    TopStatsViewModel(
        id = 128,
        season = 2024,
        type = type,
        topStatsRepository = FakeTopStatsRepository(persistedData, canUpdate, networkError)
    )