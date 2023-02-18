package com.ensegov.neofut.domain.use_case.home

import com.ensegov.neofut.data.repository.CompetitionsRepository
import com.ensegov.neofut.data.repository.FakeCompetitionsRepository
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCountryCompetitionsUseCaseTest {

    private lateinit var fakeRepository: CompetitionsRepository
    private lateinit var getCountryCompetitions: GetCountryCompetitionsUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Default)
        fakeRepository = FakeCompetitionsRepository()
        getCountryCompetitions = GetCountryCompetitionsUseCase(fakeRepository, Dispatchers.Main)
    }

    @Test
    fun flowInitialValue_isEmpty() = runTest {
        val flow = getCountryCompetitions()

        val allCompetitions = flow.first()

        allCompetitions shouldBe emptyList()
    }

    @Test
    fun flowEmission_fillsList() = runBlocking {
        val flow = getCountryCompetitions()

        delay(1500L)

        val allCompetitions = flow.first()

        allCompetitions.isEmpty() shouldBe false
    }
}