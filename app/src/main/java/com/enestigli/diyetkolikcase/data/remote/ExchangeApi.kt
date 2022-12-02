package com.enestigli.diyetkolikcase.data.remote

import okhttp3.internal.connection.Exchange
import retrofit2.http.Path
import retrofit2.http.GET

interface ExchangeApi {

    // URL -> https://v6.exchangerate-api.com/v6/1cc443134aed4ac846d97c1e/latest/USD

    @GET("/v6/1cc443134aed4ac846d97c1e/latest/{currency}")
    suspend fun getWordInfo(@Path("currency") currency: String): ExchangeDto

}