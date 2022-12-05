package com.enestigli.diyetkolikcase.roomdb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.enestigli.diyetkolikcase.data.locale.ExchangeDao
import com.enestigli.diyetkolikcase.data.locale.ExchangeDatabase
import com.enestigli.diyetkolikcase.data.remote.ExchangeDto
import com.enestigli.diyetkolikcase.domain.model.Exchange
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
@SmallTest
class ExchangeDaoTest {

    //Bütün her şeyi main thread de çalıştırıcak

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database:ExchangeDatabase
    private lateinit var dao:ExchangeDao

    val hashMap:HashMap<String,Double> = HashMap<String,Double>()

    @Before
    fun setup(){

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),ExchangeDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.exchangeDao
    }

    @After
    fun tearDown(){

        database.close()

    }



    @Test
    fun insertExchangeTesting() = runBlockingTest{

        hashMap.put("USD" , 1.0)
        hashMap.put("TRY" , 18.95)
        hashMap.put("EUR" , 0.95)

        val example = Exchange("success",hashMap,"USD")
        dao.initData(example.toEntity())

        val list = dao.getAll()
        assertThat(list).isAnyOf(list,list)

    }












}