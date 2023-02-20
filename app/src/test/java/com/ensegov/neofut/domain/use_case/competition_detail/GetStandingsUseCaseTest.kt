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

    "Existing id and non existing season - should return empty list" {
        coroutineScope {
            val flow = getStandings(2, 2021)

            val standings = flow.first()

            standings.size shouldBe 0
        }
    }

    "Existing id and season - list size should be 3" {
        coroutineScope {
            val flow = getStandings(39, 2021)

            val standings = flow.first()

            standings.size shouldBe 3
        }
    }
})
