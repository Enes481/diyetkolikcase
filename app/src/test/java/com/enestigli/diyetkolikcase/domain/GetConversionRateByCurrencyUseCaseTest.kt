package com.enestigli.diyetkolikcase.domain

import com.enestigli.diyetkolikcase.data.repo.FakeExchangeRepository
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.getconversionratebycurrency.GetConversionRateByCurrencyUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class GetConversionRateByCurrencyUseCaseTest {

    private lateinit var getByCurrency : GetConversionRateByCurrencyUseCase
    private lateinit var fakeRepository: FakeExchangeRepository

    @Before
    fun setUp() {
        fakeRepository = FakeExchangeRepository()
        getByCurrency = GetConversionRateByCurrencyUseCase(fakeRepository)


    }

    @Test
    fun `get conversion by currency value test`() = runBlockingTest {

        val result = getByCurrency.getConversionRateByCurrency("USD")
        assertThat(result).isEqualTo(1.0)

    }





}