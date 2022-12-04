package com.enestigli.diyetkolikcase.presentation.splashscreen



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.update.UpdateExchangeUseCase
import com.enestigli.diyetkolikcase.util.Constants.DEFAULT_CURRENCY
import com.enestigli.diyetkolikcase.util.Constants.PREF_DEFAULT_VALUE
import com.enestigli.diyetkolikcase.util.Constants.PREF_SAVED_KEY
import com.enestigli.diyetkolikcase.util.SharedPrefHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val insertExchangeUseCase: InsertExchangeUseCase,
    private val updateExchangeUseCase: UpdateExchangeUseCase,
    private val getAllExchangeUseCase: GetAllExchangeUseCase,
    private val sharedPrefHelper: SharedPrefHelper
) : ViewModel() {


    init {

        if(sharedPrefHelper.getStringFromShared().equals(PREF_DEFAULT_VALUE))
            insertExchanges()

    }

    private fun isInsertToRoom(){
        sharedPrefHelper.setStringToShared(PREF_SAVED_KEY)
    }

    private fun insertExchanges() {

        viewModelScope.launch {


            insertExchangeUseCase.insert(DEFAULT_CURRENCY)
        }

        isInsertToRoom()

    }


    fun update() {

        viewModelScope.launch {
            updateExchangeUseCase.updateExchange(getAllExchangeUseCase.get(DEFAULT_CURRENCY))
        }

    }

}