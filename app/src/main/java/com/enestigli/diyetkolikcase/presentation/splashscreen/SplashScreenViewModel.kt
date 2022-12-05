package com.enestigli.diyetkolikcase.presentation.splashscreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.update.UpdateExchangeUseCase
import com.enestigli.diyetkolikcase.util.Constants.DEFAULT_CURRENCY
import com.enestigli.diyetkolikcase.util.Constants.PREF_DEFAULT_VALUE
import com.enestigli.diyetkolikcase.util.Constants.PREF_NAME
import com.enestigli.diyetkolikcase.util.Constants.PREF_SAVED_KEY
import com.enestigli.diyetkolikcase.util.SharedPrefHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val insertExchangeUseCase: InsertExchangeUseCase,
    private val updateExchangeUseCase: UpdateExchangeUseCase,
    private val getAllExchangeUseCase: GetAllExchangeUseCase,
    private val sharedPrefHelper: SharedPrefHelper
) : ViewModel() {

    var state = MutableStateFlow(0)

    init {

        if (sharedPrefHelper.getStringFromShared().equals(PREF_DEFAULT_VALUE)) {
            insertExchanges()
        }else{
            state.value = 1
        }

    }

   /* private fun isInsertToRoom() {
        sharedPrefHelper.setStringToShared(PREF_SAVED_KEY)
    }*/



    fun insertExchanges() {


        viewModelScope.launch {

            val result = insertExchangeUseCase.insert(DEFAULT_CURRENCY)
            state.value = result.toInt()
            println("result$result")
            println("state${state.value}")
        }

        sharedPrefHelper.setStringToShared(PREF_SAVED_KEY)




    }


    fun update() {

        viewModelScope.launch {
            updateExchangeUseCase.updateExchange(getAllExchangeUseCase.get(DEFAULT_CURRENCY))
        }

    }

}