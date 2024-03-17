package com.ensegov.neofut.competition_detail.presentation.standings

import android.util.Log
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.createFakeGroups
import com.ensegov.neofut.competition_detail.data.repository.FakeStandingsRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.setMain

private const val TAG = "StandingsViewModelTest"

@OptIn(ExperimentalCoroutinesApi::class)
class StandingsViewModelTest : StringSpec({

    mockkStatic(Log::class)
    every { Log.d(any(), any()) } returns 0

    val databaseResult = UiState.Success(createFakeGroups(3))
    val networkResult = UiState.Success(createFakeGroups(5))

    beforeTest {
        Dispatchers.setMain(Dispatchers.Default)
    }

    "$TAG - ViewModel initialization - standings value is ´UiState.Loading´" {
        val standingsViewModel = getViewModel(FakeStandingsRepository())
        standingsViewModel.standings.value shouldBe UiState.Success(emptyList())
    }

    "$TAG - has persisted data - cannot update - retrieves from database" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(
                hasPersistedData = true,
                canUpdate = false
            )
        )
        delay(500L)
        standingsViewModel.standings.value shouldBe databaseResult
    }

    "$TAG - has persisted data - can update - retrieves then updates from network" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(hasPersistedData = true)
        )
        delay(100L)
        standingsViewModel.standings.value shouldBe databaseResult

        delay(400L)
        standingsViewModel.standings.value shouldBe networkResult
    }

    "$TAG - has persisted data - can update - retrieves and network request fails" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(
                hasPersistedData = true,
                requestFailure = true
            )
        )
        delay(500L)
        standingsViewModel.standings.value shouldBe databaseResult
    }

    "$TAG - no persisted data - makes request from network" {
        val standingsViewModel = getViewModel(FakeStandingsRepository())
        delay(500L)
        standingsViewModel.standings.value shouldBe networkResult
    }

    "$TAG - no persisted data - fails request from network" {
        val standingsViewModel = getViewModel(
            FakeStandingsRepository(requestFailure = true)
        )
        delay(500L)
        standingsViewModel.standings.value shouldBe UiState.Error("")
    }
})

private fun getViewModel(repository: FakeStandingsRepository) =
    StandingsViewModel(
        standingsRepository = repository,
        id = 1,
        season = 2024
    )