package com.enestigli.diyetkolikcase.presentation.exchangeresultscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestigli.diyetkolikcase.R
import com.enestigli.diyetkolikcase.ui.theme.lightBlue
import com.enestigli.diyetkolikcase.util.Screen

@Composable
fun ExchangeResultScreen(
    navController: NavController,
    viewModel: ExchangeResultViewModel = hiltViewModel()

) {



    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.ic_ok_256),
            contentDescription = "success"
        )

        Text(
            text = "Success",
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            fontSize = 22.sp
        )


        Text(
            text = "${viewModel.inputValue}" +
                    "${viewModel.firstConversion}" +
                    "=" +
                    "${viewModel.secondConversion}" +
                    "${viewModel.result} ",

            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp
        )


        Spacer(modifier = Modifier.padding(120.dp))

        Button(
            onClick =
            {
                navController.navigate(Screen.ExchangeMainScreen.route)
            },

            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),

            colors = ButtonDefaults.buttonColors(
                backgroundColor = lightBlue,
                contentColor = Color.White
            ),

            shape = MaterialTheme.shapes.medium,

            contentPadding = PaddingValues(8.dp),

            ) {
            Text(text = "Back To Exchange")
        }

    }


}