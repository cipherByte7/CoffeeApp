package com.example.coffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeapp.Presentation.screens.DetailScreen.DSTopAppBar
import com.example.coffeeapp.Presentation.screens.HomeScreen.HomeScreen
import com.example.coffeeapp.Presentation.theme.CoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DSTopAppBar()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeAppTheme {
        //HomeScreen()
    }
}