package com.enestigli.diyetkolikcase.presentation.exchangemainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestigli.diyetkolikcase.R
import com.enestigli.diyetkolikcase.ui.theme.lightBlue
import com.enestigli.diyetkolikcase.ui.theme.lightGray
import com.enestigli.diyetkolikcase.ui.theme.lightGray2


@Composable
fun ExchangeMainScreen(
    navController: NavController,
    viewModel: ExchangeMainViewModel = hiltViewModel()
) {


    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(50.dp))
        DropDownMenu()
        Spacer(modifier = Modifier.padding(50.dp))

        OutLineTextFieldSample()
        Spacer(modifier = Modifier.padding(5.dp))

        finalAmountTxt(result = " $ 102")
        Spacer(modifier = Modifier.padding(30.dp))

        roundedTxt(base_code = "$", exchange_value = 20.0, exchange_currency = "eur")
        Spacer(modifier = Modifier.padding(5.dp))
        ExchangeBtn()
    }


}

@Composable
fun OutLineTextFieldSample() {

    var text by remember { mutableStateOf(TextFieldValue("")) }


    OutlinedTextField(
        label = {
            Text(
                text = "Enter currency amount",
                style = TextStyle(
                    color = MaterialTheme.colors.primaryVariant,
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary,
            unfocusedBorderColor = MaterialTheme.colors.secondary,
            focusedLabelColor = MaterialTheme.colors.secondary,
            cursorColor = MaterialTheme.colors.primaryVariant
        ),

        value = text,
        onValueChange = { text = it },
    )

}

@Composable
fun DropDownMenu() {


    var expanded1 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }

    var selectedItem1 by remember { mutableStateOf("Select Item") }
    var selectedItem2 by remember { mutableStateOf("Select Item") }

    val itemList1 = listOf(
        "USD", "TRY", "EUR", "AMD", "AFN", "BGN"
    )
    val itemList2 = listOf(
        "USD", "TRY", "EUR", "AMD", "AFN", "BGN"
    )

    /*  Column(
          Modifier
              .fillMaxSize()
              .padding(vertical = 20.dp),
          verticalArrangement = Arrangement.Top,
          Alignment.CenterHorizontally
      ) {*/

    Box {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {


            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightGray2),
                onClick = { expanded1 = true }) {
                Row {
                    Text("$selectedItem1  ")
                    Icon(Icons.Default.ArrowDropDown, "")
                }
            }
            DropdownMenu(
                expanded = expanded1,
                onDismissRequest = { expanded1 = false },
            ) {
                itemList1.forEach {
                    DropdownMenuItem(
                        onClick = {
                            expanded1 = false
                            selectedItem1 = it
                        }
                    ) { Text(it) }
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))

            Image(
                modifier = Modifier.padding(5.dp),
                painter = painterResource(id = R.drawable.ic_currency_exchange_96),
                contentDescription = "exchange icon"
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightGray2),
                onClick = { expanded2 = true }) {
                Row {
                    Text("$selectedItem2  ")
                    Icon(Icons.Default.ArrowDropDown, "")
                }
            }


            DropdownMenu(
                expanded = expanded2,
                onDismissRequest = { expanded2 = false },
            ) {
                itemList2.forEach {
                    DropdownMenuItem(
                        onClick = {
                            expanded2 = false
                            selectedItem2 = it
                        }
                    ) { Text(it) }
                }
            }
        }

    }



}

@Composable
fun finalAmountTxt(result:String) {

   Text(
       text = "final amount:${result}",
       modifier = Modifier.padding(3.dp) )

}
@Composable
fun ExchangeBtn() {

    Button(
        onClick =
        {

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
        Text(text = "Exchange")
    }

}


@Composable
fun roundedTxt(base_code:String,exchange_value:Double,exchange_currency:String){



   Text(text = "1 $base_code = $exchange_value $exchange_currency")
    
}


