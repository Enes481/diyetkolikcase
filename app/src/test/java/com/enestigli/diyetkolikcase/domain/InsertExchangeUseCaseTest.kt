package com.enestigli.diyetkolikcase.domain

import com.enestigli.diyetkolikcase.data.repo.FakeExchangeRepository
import com.enestigli.diyetkolikcase.domain.model.Exchange
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test


class InsertExchangeUseCaseTest {

    private lateinit var get: GetAllExchangeUseCase
    private lateinit var insert : InsertExchangeUseCase
    private lateinit var fakeRepository: FakeExchangeRepository

    var hashMap: HashMap<String, Double> = hashMapOf("USD" to 1.0, "TRY" to 18.45, "EUR" to 0.95)

    @Before
    fun setUp() {
        fakeRepository = FakeExchangeRepository()
        get = GetAllExchangeUseCase(fakeRepository)
        insert = InsertExchangeUseCase(fakeRepository)

    }


    @Test
    fun `get and insert test`() = runBlockingTest{


        insert.insert("USD")
        val exchanges = get.get("USD")
        val exchange = Exchange("success",hashMap,"USD")
        assertThat(exchanges).isEqualTo(exchange)

    }






}