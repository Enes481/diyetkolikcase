package com.enestigli.diyetkolikcase.presentation.splashscreen



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.update.UpdateExchangeUseCase
import com.enestigli.diyetkolikcase.util.Constants.DEFAULT_CURRENCY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val insertExchangeUseCase: InsertExchangeUseCase,
    private val updateExchangeUseCase: UpdateExchangeUseCase,
    private val getAllExchangeUseCase: GetAllExchangeUseCase,

) : ViewModel() {


    init {

        insertExchanges()
    }


    private fun insertExchanges() {

        viewModelScope.launch {

            insertExchangeUseCase.insert(DEFAULT_CURRENCY)
        }


    }


    fun update() {

        viewModelScope.launch {
            updateExchangeUseCase.updateExchange(getAllExchangeUseCase.get(DEFAULT_CURRENCY))
        }

    }

}