package com.enestigli.diyetkolikcase.domain.usecase.update

import com.enestigli.diyetkolikcase.data.remote.ExchangeDto
import com.enestigli.diyetkolikcase.domain.model.Exchange
import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import javax.inject.Inject

class UpdateExchangeUseCase @Inject constructor(
    private val repository: ExchangeRepository
) {


    suspend fun updateExchange(exchange: Exchange) {


         repository.update(exchange)

    }
}