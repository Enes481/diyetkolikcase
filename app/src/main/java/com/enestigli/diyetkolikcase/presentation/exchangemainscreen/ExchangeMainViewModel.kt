package com.enestigli.diyetkolikcase.presentation.exchangemainscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestigli.diyetkolikcase.domain.usecase.getconversionratebycurrency.GetConversionRateByCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeMainViewModel @Inject constructor(
    private val getConversionRateByCurrencyUseCase: GetConversionRateByCurrencyUseCase
) : ViewModel() {


    var isDialogShown by mutableStateOf(false)
        private set

    var dropDownMenuItem1 by mutableStateOf("")
    var dropDownMenuItem2 by mutableStateOf("")

    var outLineTxtFieldValue by mutableStateOf(TextFieldValue(""))

    var firstConversionRate by mutableStateOf(0.0)
    var secondConversionRate by mutableStateOf(0.0)

    var resultState by mutableStateOf(0.0)



    fun onConfirmClick() {
        isDialogShown = true
        getConversionRateByCurrency()

    }

    fun onDismissClick() {

        isDialogShown = false

    }


    fun check(context: Context): Boolean {

        if (outLineTxtFieldValue.text.isNullOrEmpty() ||
            dropDownMenuItem1 == "" ||
            dropDownMenuItem2 == ""  ||
            outLineTxtFieldValue.text.toInt() <= 0 ) {

            Toast.makeText(context, "Please Enter The Fields Correctly And Completely !", Toast.LENGTH_LONG).show()
            return false
        }
        return true

    }

    private fun getConversionRateByCurrency() {

        viewModelScope.launch {

            val firstRate = async {
                getConversionRateByCurrencyUseCase.getConversionRateByCurrency(dropDownMenuItem1)
            }

            val secondRate = async {
                getConversionRateByCurrencyUseCase.getConversionRateByCurrency(dropDownMenuItem2)
            }

            firstConversionRate = firstRate.await()
            secondConversionRate = secondRate.await()


            val result = async {
                calculate()
            }
            resultState = result.await()

        }
    }


    private fun calculate(): Double {

        if (!firstConversionRate.equals(0.0) && !secondConversionRate.equals(0.0)) {

            val amount = outLineTxtFieldValue.text.toInt()
            return (amount / firstConversionRate) * secondConversionRate

        }

        return 1.1
    }

}