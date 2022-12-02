package com.enestigli.diyetkolikcase.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enestigli.diyetkolikcase.MainActivity
import com.enestigli.diyetkolikcase.presentation.exchangemainscreen.ExchangeMainScreen
import com.enestigli.diyetkolikcase.presentation.exchangeresultscreen.ExchangeResultScreen
import com.enestigli.diyetkolikcase.presentation.splashscreen.SplashScreen
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

        composable(route = Screen.ExchangeResultScreen.route) {
            ExchangeResultScreen(navController)
        }
    }


}