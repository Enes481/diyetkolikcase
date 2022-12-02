package com.enestigli.diyetkolikcase.domain.repository

import com.enestigli.diyetkolikcase.data.remote.ExchangeDto
import com.enestigli.diyetkolikcase.domain.model.Exchange
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ExchangeRepository {

    suspend fun initData(currency: String)
    suspend fun update(exchange: ExchangeDto)
    suspend fun get(currency: String) : Exchange
}