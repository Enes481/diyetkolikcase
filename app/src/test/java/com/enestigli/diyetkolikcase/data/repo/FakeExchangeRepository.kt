package com.enestigli.diyetkolikcase.data.repo

import com.enestigli.diyetkolikcase.domain.model.Exchange
import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository

class FakeExchangeRepository : ExchangeRepository {

    var hashMap: HashMap<String, Double> = hashMapOf("USD" to 1.0, "TRY" to 18.45, "EUR" to 0.95)

    private val exchanges = Exchange("success",hashMap,"USD")



    override suspend fun initData(currency: String) {


        val result = get(currency)


    }

    override suspend fun update(exchange: Exchange) {

        Exchange("success",hashMap,"EUR")


    }

    override suspend fun get(currency: String): Exchange {

        return exchanges

    }

    override suspend fun getConversionRateByCurrency(currency: String) : Double {
        return exchanges.toEntity().conversion_rates.entries.find { it.key == currency }!!.value
    }
}