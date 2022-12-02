package com.enestigli.diyetkolikcase.util

sealed class Screen(val route:String) {

    object MainScreen                           : Screen("main_activity")
    object ExchangeMainScreen                   : Screen("exchange_main_screen")
    object ExchangeResultScreen                 : Screen("exchange_result_screen")
    object SplashScreen                         : Screen("splash_screen")




}
