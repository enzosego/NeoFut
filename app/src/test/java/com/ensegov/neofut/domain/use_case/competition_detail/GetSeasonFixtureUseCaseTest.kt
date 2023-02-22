package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import com.ensegov.neofut.data.repository.FakeCompetitionDetailRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class GetSeasonFixtureUseCaseTest : StringSpec({

    lateinit var getSeasonFixture: GetSeasonFixtureUseCase
    lateinit var fakeRepository: CompetitionDetailRepository

    beforeEach {
        Dispatchers.setMain(Dispatchers.Default)
        fakeRepository = FakeCompetitionDetailRepository()
        getSeasonFixture = GetSeasonFixtureUseCase(fakeRepository, Dispatchers.Main)
    }

    "Non existing id - should return empty list" {
        coroutineScope {
            val flow = getSeasonFixture(39, 2022)

            val seasonFixture = flow.first()

            seasonFixture.size shouldBe 0
        }
    }

    "Non existing season - should return empty list" {
        coroutineScope {
            val flow = getSeasonFixture(128, 2021)

            val seasonFixture = flow.first()

            seasonFixture.size shouldBe 0
        }
    }

    "Existing id and season - should return fixture" {
        coroutineScope {
            val flow = getSeasonFixture(2, 2022)

            val seasonFixture = flow.first()

            seasonFixture.size shouldBe 48
        }
    }

    "Non existing id - should be created".config(blockingTest = true) {
        val flow = getSeasonFixture(39, 2021)

        delay(500L)

        val seasonFixture = flow.first()

        seasonFixture.size shouldBe 38
    }

    "Non existing season - should be created".config(blockingTest = true) {
        val flow = getSeasonFixture(2, 2020)

        delay(500L)

        val seasonFixture = flow.first()

        seasonFixture.size shouldBe 38
    }
})