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

    "flow's initial value is empty" {
        coroutineScope {
            val flow = getStandings(0, 0)

            val allStandings = flow.first()

            allStandings.size shouldBe 0
        }
    }

    "flow emission fill list".config(blockingTest = true) {
        val flow = getStandings(0, 0)

        delay(1500L)

        val allStandings = flow.first()

        allStandings.isEmpty() shouldBe false
        allStandings.size shouldBe 3
    }
})
