package com.enestigli.diyetkolikcase.domain.usecase.insert

import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import java.util.*
import javax.inject.Inject

class InsertExchangeUseCase @Inject constructor(
    private val repository: ExchangeRepository
) {


    suspend fun insert(currency: String) : Long{

        return repository.initData(currency)
    }
}