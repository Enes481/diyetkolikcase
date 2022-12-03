package com.enestigli.diyetkolikcase.presentation.splashscreen

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.putString
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestigli.diyetkolikcase.R
import com.enestigli.diyetkolikcase.util.Screen
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel : SplashScreenViewModel = hiltViewModel()
) {


    val sdf = SimpleDateFormat("yyyy-MM-dd")
    val currentDate = sdf.format(Date())

    val context: Context = LocalContext.current

    val sharedPreferences = context.getSharedPreferences("date",Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()

    editor.apply{

        putString("date",currentDate)

    }.apply()

    println(sharedPreferences.getString("date","defaeult"))

    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )


        delay(3000L)
        navController.navigate(Screen.ExchangeMainScreen.route)
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_currency_exchange_logo_512),
            contentDescription = "Logo"
        )
    }


}


