package com.enestigli.diyetkolikcase.domain.model

import com.enestigli.diyetkolikcase.data.locale.entity.ExchangeEntity

data class Exchange(
    val result :String,
    val conversionRates: HashMap<String,Double>,
    val base_code :String
){
    fun toEntity() = ExchangeEntity(
        result = result,
        conversion_rates = conversionRates,
        base_code = base_code
    )
}