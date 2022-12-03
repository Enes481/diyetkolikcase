package com.enestigli.diyetkolikcase.presentation.exchangemainscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestigli.diyetkolikcase.R
import com.enestigli.diyetkolikcase.ui.theme.*


@Composable
fun ExchangeMainScreen(
    navController: NavController,
    viewModel: ExchangeMainViewModel = hiltViewModel()
) {



    val context = LocalContext.current

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

        FinalAmountTxt(result = " $ 102")
        Spacer(modifier = Modifier.padding(30.dp))

        RoundedTxt(base_code = "$", exchange_value = 20.0, exchange_currency = "eur")
        Spacer(modifier = Modifier.padding(5.dp))
        ExchangeBtn(context)

    }


}

@Composable
fun OutLineTextFieldSample(
    viewModel: ExchangeMainViewModel = hiltViewModel()
) {


    var outLineTextField by remember { mutableStateOf(TextFieldValue("")) }

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

        value = outLineTextField,
        onValueChange = {
            outLineTextField = it
            viewModel.outLineTxtFieldValue = it
        },

        )

}

@Composable
fun DropDownMenu(
    viewModel: ExchangeMainViewModel = hiltViewModel()
) {


    var expanded1 by remember { mutableStateOf(false) }
    var expanded2 by remember { mutableStateOf(false) }

    var selectedItem1 by remember { mutableStateOf("") }
    var selectedItem2 by remember { mutableStateOf("") }


    val itemList1 = listOf(
        "USD", "TRY", "EUR", "AMD", "AFN", "BGN"
    )
    val itemList2 = listOf(
        "USD", "TRY", "EUR", "AMD", "AFN", "BGN"
    )

    /* Column(
           Modifier
               .fillMaxSize()
               .padding(vertical = 20.dp),
           verticalArrangement = Arrangement.Top,
           Alignment.CenterHorizontally
       ) {*/

    Box {
        Row(
            modifier = Modifier.fillMaxWidth(),
            Arrangement.Center,
            verticalAlignment = Alignment.Top

        ) {

            Button(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp)),
                colors = ButtonDefaults.buttonColors(backgroundColor = lightGray2),
                onClick = { expanded1 = true }) {
                Row {
                    Text("$selectedItem1")
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
                            viewModel.dropDownMenuItem1 = it
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
                            viewModel.dropDownMenuItem2 = it
                        }
                    ) { Text(it) }
                }
            }
        }

    }

}

@Composable
fun FinalAmountTxt(result: String) {

    Text(
        text = "final amount:${result}",
        modifier = Modifier.padding(3.dp)
    )

}

@Composable
fun ExchangeBtn(
    context: Context,
    viewModel: ExchangeMainViewModel = hiltViewModel(),

    ) {



    val conversionValue = viewModel.firstConversionValue
    val conversionValue2 = viewModel.secondConversionValue

    Button(
        onClick =
        {

            val result = viewModel.check(context)

            if (result) {
                viewModel.onConfirmClick()
            }


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

    if (viewModel.isDialogShown) {

        AlertDialog(
            onDismiss = {
                viewModel.onDismissClick()
            },
            onConfirm = {

               viewModel.getFirstConversionRateByCurrency(viewModel.dropDownMenuItem1)
               viewModel.getSecondConversionRateByCurrency(viewModel.dropDownMenuItem2)

                println(conversionValue)
                println(conversionValue2)
            }
        )
    }

}


@Composable
fun RoundedTxt(base_code: String, exchange_value: Double, exchange_currency: String) {

    Text(text = "1 $base_code = $exchange_value $exchange_currency")

}


@Composable
fun AlertDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    viewModel: ExchangeMainViewModel = hiltViewModel()
) {
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(2.dp, color = orangish, shape = RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {

                Text(
                    text = "Confirm Operation.",
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "" +
                            "Are you sure you want to convert from " +
                            "${viewModel.outLineTxtFieldValue.text}" +
                            " ${viewModel.dropDownMenuItem1} to ${viewModel.dropDownMenuItem2}?",

                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Teal200,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        shape = CircleShape
                    ) {
                        Text(
                            text = "Cancel",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Button(
                        onClick = {
                            onConfirm()
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Teal200,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        shape = CircleShape
                    ) {
                        Text(
                            text = "Confirm",
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                        )
                    }
                }

            }
        }
    }


}

