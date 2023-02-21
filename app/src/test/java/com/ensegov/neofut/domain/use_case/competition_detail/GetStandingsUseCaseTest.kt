package com.ensegov.neofut.domain.use_case.competition_detail

import com.ensegov.neofut.data.repository.CompetitionDetailRepository
import com.ensegov.neofut.data.repository.FakeCompetitionDetailRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class GetStandingsUseCaseTest : StringSpec({

    lateinit var getStandings: GetStandingsUseCase
    lateinit var fakeRepository: CompetitionDetailRepository

    beforeTest {
        Dispatchers.setMain(Dispatchers.Default)
        fakeRepository = FakeCompetitionDetailRepository()
        getStandings = GetStandingsUseCase(fakeRepository, Dispatchers.Main)
    }

    "Non existing id - should return empty list" {
        coroutineScope {
            val flow = getStandings(0, 2022)

            val standings = flow.first()

            standings.size shouldBe 0
        }
    }

    "Non existing season - should return empty list" {
        coroutineScope {
            val flow = getStandings(2, 2021)

            val standings = flow.first()

            standings.size shouldBe 0
        }
    }

    "Existing id and season - list should not be empty" {
        coroutineScope {
            val flow = getStandings(39, 2021)

            val standings = flow.first()

            standings.size shouldBe 3
        }
    }

    "Non existing id - should create standings".config(blockingTest = true) {
        val flow = getStandings(128, 2019)

        delay(500L)

        val standings = flow.first()

        standings.size shouldBe 3
    }

    "Non existing season - should create standings".config(blockingTest = true) {
        val flow = getStandings(39, 2022)

        delay(500L)

        val standings = flow.first()

        standings.size shouldBe 3
    }
})
