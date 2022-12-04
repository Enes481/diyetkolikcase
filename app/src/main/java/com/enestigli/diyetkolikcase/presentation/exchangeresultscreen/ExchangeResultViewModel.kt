package com.enestigli.diyetkolikcase.presentation.exchangeresultscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.util.Constants.FIRST_CONVERSION_KEY
import com.enestigli.diyetkolikcase.util.Constants.FIRST_CONVERSION_RATE_KEY
import com.enestigli.diyetkolikcase.util.Constants.INPUT_VALUE_KEY
import com.enestigli.diyetkolikcase.util.Constants.RESULT_OF_EXCHANGE_KEY
import com.enestigli.diyetkolikcase.util.Constants.SECOND_CONVERSION_KEY
import com.enestigli.diyetkolikcase.util.Constants.SECOND_CONVERSION_RATE_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeResultViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _inputValue: String? = savedStateHandle.get(INPUT_VALUE_KEY)
    private val _firstConversion: String? = savedStateHandle.get(FIRST_CONVERSION_KEY)
    private val _secondConversion: String? = savedStateHandle.get(SECOND_CONVERSION_KEY)
    private val _result:Float? = savedStateHandle.get(RESULT_OF_EXCHANGE_KEY)



    var inputValue = _inputValue
    var firstConversion = _firstConversion
    var secondConversion = _secondConversion
    var result = _result







}
