package com.example.coffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeapp.Presentation.navigation.NavGraph
import com.example.coffeeapp.Presentation.theme.CoffeeAppTheme
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.Presentation.viewmodel.ThemeViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val themeViewModel: ThemeViewModel = viewModel(
                factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            )

            val isDarkTheme by themeViewModel.isDarkTheme.collectAsStateWithLifecycle()

            CoffeeAppTheme(
                darkTheme = isDarkTheme
            ) {
                NavGraph()
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