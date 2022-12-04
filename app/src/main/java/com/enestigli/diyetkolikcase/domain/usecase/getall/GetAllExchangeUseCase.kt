package com.enestigli.diyetkolikcase.domain.usecase.getall

import com.enestigli.diyetkolikcase.domain.model.Exchange
import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import javax.inject.Inject

class GetAllExchangeUseCase @Inject constructor(
    private val repository: ExchangeRepository
){


    suspend fun get(currency:String) : Exchange {
        return repository.get(currency)
    }

}