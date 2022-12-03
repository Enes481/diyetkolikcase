package com.enestigli.diyetkolikcase.presentation.exchangemainscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.data.remote.FirstConversionValue
import com.enestigli.diyetkolikcase.data.remote.SecondConversionValue
import com.enestigli.diyetkolikcase.domain.usecase.getall.GetAllExchangeUseCase
import com.enestigli.diyetkolikcase.domain.usecase.getconversionratebycurrency.GetConversionRateByCurrencyUseCase
import com.enestigli.diyetkolikcase.domain.usecase.insert.InsertExchangeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeMainViewModel @Inject constructor(
    private val exchangeInsertUseCase: InsertExchangeUseCase,
    private val exchangeGetAllUseCase:GetAllExchangeUseCase,
    private val getConversionRateByCurrencyUseCase: GetConversionRateByCurrencyUseCase
) : ViewModel() {


    var isDialogShown by mutableStateOf(false)
        private set

    var dropDownMenuItem1 by mutableStateOf("")
    var dropDownMenuItem2 by mutableStateOf("")

    var outLineTxtFieldValue by mutableStateOf(TextFieldValue(""))

    var firstConversionValue by mutableStateOf<FirstConversionValue?>(null)
    var secondConversionValue by mutableStateOf<SecondConversionValue?>(null)


    private val _state = mutableStateOf(ExchangeState())
    var state:State<ExchangeState> = _state

    fun onConfirmClick(){
        isDialogShown = true
    }

    fun onDismissClick() {
        isDialogShown = false
    }


    fun check(context: Context) : Boolean{

        if(outLineTxtFieldValue.text.isNullOrEmpty() || dropDownMenuItem1 == "" || dropDownMenuItem2 == ""){

            Toast.makeText(context,"please select a value and currency ",Toast.LENGTH_LONG).show()
            return false
        }
        return true

    }

   fun getFirstConversionRateByCurrency(currency:String)   {



       viewModelScope.launch {

           val first = getConversionRateByCurrencyUseCase.getConversionRateByCurrency(currency)
           firstConversionValue = FirstConversionValue(first)

       }


   }

    fun getSecondConversionRateByCurrency(currency:String)  {


        viewModelScope.launch {


            val second = getConversionRateByCurrencyUseCase.getConversionRateByCurrency(currency)
            secondConversionValue = SecondConversionValue(second)



        }


    }

}