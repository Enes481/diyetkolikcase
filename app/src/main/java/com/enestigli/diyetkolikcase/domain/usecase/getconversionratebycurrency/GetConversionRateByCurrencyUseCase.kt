package com.enestigli.diyetkolikcase.domain.usecase.getconversionratebycurrency

import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetConversionRateByCurrencyUseCase @Inject constructor(
    private val repository: ExchangeRepository
) {

   suspend fun getConversionRateByCurrency(currency:String) :Double {

        return repository.getConversionRateByCurrency(currency)

    }


}