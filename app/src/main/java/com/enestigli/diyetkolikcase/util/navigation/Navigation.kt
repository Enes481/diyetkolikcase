package com.enestigli.diyetkolikcase.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.enestigli.diyetkolikcase.MainActivity
import com.enestigli.diyetkolikcase.presentation.exchangemainscreen.ExchangeMainScreen
import com.enestigli.diyetkolikcase.presentation.exchangeresultscreen.ExchangeResultScreen
import com.enestigli.diyetkolikcase.presentation.splashscreen.SplashScreen
import com.enestigli.diyetkolikcase.util.Constants.FIRST_CONVERSION_KEY
import com.enestigli.diyetkolikcase.util.Constants.FIRST_CONVERSION_RATE_KEY
import com.enestigli.diyetkolikcase.util.Constants.INPUT_VALUE_KEY
import com.enestigli.diyetkolikcase.util.Constants.RESULT_OF_EXCHANGE_KEY
import com.enestigli.diyetkolikcase.util.Constants.SECOND_CONVERSION_KEY
import com.enestigli.diyetkolikcase.util.Constants.SECOND_CONVERSION_RATE_KEY
import com.enestigli.diyetkolikcase.util.Screen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = Screen.MainScreen.route) {
            MainActivity()
        }

        composable(route = Screen.ExchangeMainScreen.route) {
            ExchangeMainScreen(navController)

        }

        composable(
            route = Screen.ExchangeResultScreen.route,
            arguments = listOf(

                navArgument(INPUT_VALUE_KEY) {
                    type = NavType.StringType
                },
                navArgument(FIRST_CONVERSION_KEY) {
                    type = NavType.StringType
                },
                navArgument(SECOND_CONVERSION_KEY) {
                    type = NavType.StringType
                },
                navArgument(RESULT_OF_EXCHANGE_KEY) {
                    type = NavType.FloatType
                },
                navArgument(FIRST_CONVERSION_RATE_KEY) {
                    type = NavType.StringType
                },
                navArgument(SECOND_CONVERSION_RATE_KEY) {
                    type = NavType.StringType
                }

            )) {

            ExchangeResultScreen(navController = navController)
        }
    }


}