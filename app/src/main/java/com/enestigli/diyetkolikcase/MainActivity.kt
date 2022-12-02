package com.enestigli.diyetkolikcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import com.enestigli.diyetkolikcase.ui.theme.DiyetKolikCaseTheme
import com.enestigli.diyetkolikcase.util.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiyetKolikCaseTheme {
                Surface(color = Color.White)
                {
                    Navigation()
                }
              
            }
        }
    }
}


