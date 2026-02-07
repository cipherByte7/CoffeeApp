package com.example.coffeeapp.Presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.coffeeapp.Presentation.screens.DetailScreen.DetailScreen
import com.example.coffeeapp.Presentation.screens.HomeScreen.HomeScreen
import com.example.coffeeapp.Presentation.screens.cartScreen.CartScreen
import com.example.coffeeapp.Presentation.screens.favouriteScreen.FavouritesScreen
import com.example.coffeeapp.Presentation.screens.profileScreen.ProfileScreen
import com.example.coffeeapp.Presentation.screens.welcomeScreen.WelcomeScreen

@Composable
fun NavGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination =   Routes.WelcomeScreen){

        composable<Routes.WelcomeScreen>{
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen>{
            HomeScreen(navController)
        }

        composable<Routes.DetailScreen>{backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailScreen>()
            DetailScreen(productId = args.productId, navController)
        }

        composable<Routes.CartScreen>{
            CartScreen(navController)
        }

        composable<Routes.FavouritesScreen>{
            FavouritesScreen(navController)
        }

        composable<Routes.ProfileScreen>{
            ProfileScreen(navController)
        }



    }
}