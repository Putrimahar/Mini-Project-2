package com.putrimaharani0087.miniproject2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.putrimaharani0087.miniproject2.screen.MainScreen
import com.putrimaharani0087.miniproject2.ui.theme.MiniProject2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiniProject2Theme {
                MainScreen()
            }
        }
    }
}
