package com.enestigli.diyetkolikcase.util

import com.enestigli.diyetkolikcase.util.Constants.FIRST_CONVERSION_KEY
import com.enestigli.diyetkolikcase.util.Constants.FIRST_CONVERSION_RATE_KEY
import com.enestigli.diyetkolikcase.util.Constants.INPUT_VALUE_KEY
import com.enestigli.diyetkolikcase.util.Constants.RESULT_OF_EXCHANGE_KEY
import com.enestigli.diyetkolikcase.util.Constants.SECOND_CONVERSION_KEY
import com.enestigli.diyetkolikcase.util.Constants.SECOND_CONVERSION_RATE_KEY

sealed class Screen(val route:String) {

    object MainScreen            : Screen(route = "main_activity")

    object SplashScreen          : Screen(route = "splash_screen")


    object ExchangeResultScreen  : Screen(route ="exchange_result_screen/{$INPUT_VALUE_KEY}/{$FIRST_CONVERSION_KEY}/{$SECOND_CONVERSION_KEY}/{$RESULT_OF_EXCHANGE_KEY}/{$FIRST_CONVERSION_RATE_KEY}/{$SECOND_CONVERSION_RATE_KEY}"
    ){
        fun passArgsToResultExchangeScreen(
            input_value:String,
            firstConversion:String,
            secondConversion:String,
            result:Double,
            firstConversionRate:String,
            secondConversionRate:String,
        ) : String {

            return "exchange_result_screen/$input_value/$firstConversion/$secondConversion/$result/$firstConversionRate/$secondConversionRate"

        }
    }

    object ExchangeMainScreen     : Screen("exchange_main_screen")







}
