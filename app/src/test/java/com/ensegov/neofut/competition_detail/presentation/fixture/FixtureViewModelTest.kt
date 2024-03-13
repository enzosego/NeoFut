package com.ensegov.neofut.competition_detail.presentation.fixture

import android.util.Log
import com.ensegov.neofut.common.presentation.model.UiState
import com.ensegov.neofut.competition_detail.createFakeRoundFixture
import com.ensegov.neofut.competition_detail.data.repository.FakeFixtureRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.spec.style.scopes.StringSpecScope
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.setMain

const val TAG = "FixtureViewModelTest"

@OptIn(ExperimentalCoroutinesApi::class)
class FixtureViewModelTest : StringSpec({

    mockkStatic(Log::class)
    every { Log.d(any(), any()) } returns 0

    beforeTest {
        Dispatchers.setMain(Dispatchers.Default)
    }

    val databaseFixture = UiState.Success(createFakeRoundFixture(count = 8))
    val networkFixture = UiState.Success(createFakeRoundFixture(count = 12))

    "$TAG - ViewModel initialization - currentFixture value is ´UiState.Loading´" {
        val fixtureViewModel = getViewModel()
        fixtureViewModel.currentFixture shouldBe UiState.Loading
    }

    "$TAG - has persisted data - retrieve round fixture from database" {
        val fixtureViewModel = getViewModel(
            FakeFixtureRepository(
                hasPersistedRoundFixture = true,
                canUpdateRoundFixture = false
            )
        )
        delay(500L)

        fixtureViewModel.currentFixture shouldBe databaseFixture
    }

    "$TAG - no persisted data - retrieves round fixture from database" {
        val fixtureViewModel = getViewModel(
            FakeFixtureRepository(hasPersistedRoundFixture = true)
        )
        delay(500L)

        fixtureViewModel.currentFixture shouldBe networkFixture
    }

    "$TAG - has persisted data - can update - retrieves then updates from network" {
        val fixtureViewModel = getViewModel(
            FakeFixtureRepository(hasPersistedRoundFixture = true)
        )
        delay(100L)
        fixtureViewModel.currentFixture shouldBe databaseFixture

        delay(400L)
        fixtureViewModel.currentFixture shouldBe networkFixture
    }

    "$TAG - currentRoundIndex is ´0´ - ´canShowPrevious´ is false - ´canShowNext´ is true" {
        val fixtureViewModel = getViewModel(
            FakeFixtureRepository(hasPersistedSeasonFixture = true)
        )

        observeValues(fixtureViewModel.canShowPrevious, fixtureViewModel.canShowNext) {
            fixtureViewModel.canShowPrevious.value shouldBe false
            fixtureViewModel.canShowNext.value shouldBe true
        }
    }

    "$TAG - currentRoundIndex is last element - ´canShowPrevious´ is true - ´canShowNext´ is false" {
        val fixtureViewModel = getViewModel()

        observeValues(fixtureViewModel.canShowNext, fixtureViewModel.canShowPrevious) {
            fixtureViewModel.canShowPrevious.value shouldBe true
            fixtureViewModel.canShowNext.value shouldBe false
        }
    }

    "$TAG - currentRoundIndex is 7 - ´canShowPrevious´ is true - ´canShowNext´ is true" {
        val fixtureViewModel = getViewModel(
            FakeFixtureRepository(
                hasPersistedSeasonFixture = true,
                currentRoundIndex = 7
            )
        )
        observeValues(fixtureViewModel.canShowPrevious, fixtureViewModel.canShowNext) {
            fixtureViewModel.canShowPrevious.value shouldBe true
            fixtureViewModel.canShowNext.value shouldBe true
        }
    }
})

private fun getViewModel(repository: FakeFixtureRepository = FakeFixtureRepository()) =
    FixtureViewModel(
        fixtureRepository  = repository,
        id = 128,
        season = 2024
    )

private suspend fun StringSpecScope.observeValues(
    canShowPrevious: StateFlow<Boolean>,
    canShowNext: StateFlow<Boolean>,
    assertions: () -> Unit
) {
    val job = launch { canShowPrevious.collect() }
    val job2 = launch { canShowNext.collect() }
    delay(500L)

    assertions()

    job.cancel()
    job2.cancel()
}