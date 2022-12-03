package com.enestigli.diyetkolikcase.data.remote

import com.enestigli.diyetkolikcase.domain.model.Exchange
import kotlinx.serialization.Serializable


@Serializable
data class ExchangeDto(
    val base_code: String,
    val conversion_rates: HashMap<String,Double>,
    val documentation: String,
    val result: String,
    val terms_of_use: String,
    val time_last_update_unix: Int,
    val time_last_update_utc: String,
    val time_next_update_unix: Int,
    val time_next_update_utc: String
) {
    fun toDomain() = Exchange(
        base_code = base_code,
        conversionRates = conversion_rates,
        result = result,

    )
}

data class FirstConversionValue(
    val first : Double

)

data class SecondConversionValue(
    val second:Double
)

