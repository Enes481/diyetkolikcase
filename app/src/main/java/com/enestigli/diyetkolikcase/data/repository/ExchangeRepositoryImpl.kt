package com.enestigli.diyetkolikcase.data.repository

import com.enestigli.diyetkolikcase.data.locale.ExchangeDao
import com.enestigli.diyetkolikcase.data.remote.ExchangeApi
import com.enestigli.diyetkolikcase.data.remote.ExchangeDto
import com.enestigli.diyetkolikcase.domain.model.Exchange
import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap
import kotlin.reflect.KClass

class ExchangeRepositoryImpl @Inject constructor(
    private val dao: ExchangeDao,
    private val api: ExchangeApi
) : ExchangeRepository {


    /* private val exchangeLiveData = MutableLiveData<Exchange>()
     val exchanges : LiveData<Exchange> = exchangeLiveData*/


    override suspend fun get(currency: String): Exchange {

        return api.getExchangeValues(currency).toDomain()

    }

    override suspend fun getConversionRateByCurrency(currency: String): Double {

         return dao.getAll().conversion_rates.entries.find { it.key == currency }!!.value


     }


    override suspend fun initData(currency: String) {

        val result = api.getExchangeValues(currency)

        dao.initData(result.toDomain().toEntity())

    }

    override suspend fun update(exchange: ExchangeDto) {

        dao.update(exchange.base_code, exchange.conversion_rates, exchange.result)
    }


}











