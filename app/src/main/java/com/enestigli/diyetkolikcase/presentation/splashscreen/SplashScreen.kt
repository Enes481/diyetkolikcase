package com.enestigli.diyetkolikcase.presentation.splashscreen

import android.content.Context
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestigli.diyetkolikcase.R
import com.enestigli.diyetkolikcase.util.Constants.PREF_DEFAULT_VALUE
import com.enestigli.diyetkolikcase.util.Constants.PREF_NAME
import com.enestigli.diyetkolikcase.util.Screen
import com.enestigli.diyetkolikcase.util.SharedPrefHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import java.util.*
import java.util.concurrent.TimeUnit


@Composable
fun SplashScreen(
    navController: NavController,
    viewModel : SplashScreenViewModel = hiltViewModel(),

) {


    val context: Context = LocalContext.current
    val sharedPreference =  context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    val state by viewModel.state.collectAsState()
    println("sasasrasd"+state)

   /* if(sharedPreference.getString(PREF_NAME).equals(PREF_DEFAULT_VALUE)){
        viewModel.insertExchanges()
    }
*/

    checkDate(context,viewModel)

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

        if(state == 1 )
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



fun checkDate(context:Context,viewModel: SplashScreenViewModel){


    val sharedPreferences = context.getSharedPreferences("date",Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()


    val date = Date(System.currentTimeMillis())
    val millis = date.time


    editor.apply{
        putLong("currentDate", millis)
    }.apply()


    val sharedDate = sharedPreferences.getLong("currentDate",1)

    val isDayPassed = (System.currentTimeMillis() - sharedDate) >= TimeUnit.DAYS.toMillis(1)

    if(isDayPassed){
       viewModel.update()
    }


}




