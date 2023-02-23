package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.repository.FakeCompetitionDetailRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class GetRoundFixtureUseCaseTest : StringSpec({

    lateinit var getRoundFixture: GetRoundFixtureUseCase

    beforeEach {
        Dispatchers.setMain(Dispatchers.Default)
        val fakeRepository = FakeCompetitionDetailRepository()
        getRoundFixture = GetRoundFixtureUseCase(fakeRepository, Dispatchers.Main)
    }

    "Non exiting id - should return empty list" {
        coroutineScope {
            val flow = getRoundFixture(128, 2022, "Regular Season - 3")

            val matchList = flow.first()

            matchList.size shouldBe 0
        }
    }

    "Non exiting season - should return empty list" {
        coroutineScope {
            val flow = getRoundFixture(2, 2020, "Preliminary Round")

            val matchList = flow.first()

            matchList.size shouldBe 0
        }
    }

    "Non exiting round - should return empty list" {
        coroutineScope {
            val flow = getRoundFixture(39, 2022, "Regular Season - 2")

            val matchList = flow.first()

            matchList.size shouldBe 0
        }
    }

    "Existing round fixture - should return list of size 10" {
        coroutineScope {
            val flow = getRoundFixture(39, 2022, "Regular Season - 3")

            val matchList = flow.first()

            matchList.size shouldBe 10
        }
    }

    "Non existing id - should crete new fixture".config(blockingTest = true) {
        val flow = getRoundFixture(140, 2022, "Regular Season - 3")

        delay(500L)

        val matchList = flow.first()

        matchList.size shouldBe 10
    }

    "Non existing season - should crete new fixture".config(blockingTest = true) {
        val flow = getRoundFixture(140, 2019, "Regular Season - 3")

        delay(500L)

        val matchList = flow.first()

        matchList.size shouldBe 10
    }

    "Non existing round - should crete new fixture".config(blockingTest = true) {
        val flow = getRoundFixture(140, 2022, "Regular Season - 1")

        delay(500L)

        val matchList = flow.first()

        matchList.size shouldBe 10
    }
})