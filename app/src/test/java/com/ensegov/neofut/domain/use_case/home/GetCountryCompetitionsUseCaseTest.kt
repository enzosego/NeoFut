package com.ensegov.neofut.domain.use_case.home

import com.ensegov.neofut.data.repository.CompetitionsRepository
import com.ensegov.neofut.data.repository.FakeCompetitionsRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class GetCountryCompetitionsUseCaseTest : StringSpec({

    lateinit var fakeRepository: CompetitionsRepository
    lateinit var getCountryCompetitions: GetCountryCompetitionsUseCase

    beforeTest {
        Dispatchers.setMain(Dispatchers.Default)
        fakeRepository = FakeCompetitionsRepository()
        getCountryCompetitions = GetCountryCompetitionsUseCase(fakeRepository, Dispatchers.Main)
    }


    "flow initial value is empty" {
        coroutineScope {
            val flow = getCountryCompetitions()

            val allCompetitions = flow.first()

            allCompetitions.isEmpty() shouldBe true
            allCompetitions.size shouldBe 0
        }
    }

    "flow emission fills list".config(blockingTest = true) {
        val flow = getCountryCompetitions()

        delay(1500L)

        val allCompetitions = flow.first()

        allCompetitions.isEmpty() shouldBe false
        allCompetitions.size shouldBe 26
    }


})
