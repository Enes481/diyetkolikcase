package com.enestigli.diyetkolikcase.presentation.exchangemainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.domain.repository.ExchangeRepository
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeMainViewModel @Inject constructor(
    private val exchangeInsertUseCase: InsertExchangeUseCase,
    private val exchangeGetAllUseCase:GetAllExchangeUseCase
) : ViewModel() {

    fun a() {

        viewModelScope.launch {

           println("exchanges values --- >  "+exchangeInsertUseCase.insert("USD"))

            println("result --*--------->"+exchangeGetAllUseCase.get("USD"))
        }


    }

}