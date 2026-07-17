package com.example.coffeeapp.Presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WelcomeScreen : Routes()
    @Serializable
    object HomeScreen : Routes()
    @Serializable
    data class DetailScreen(val productId: String) : Routes()
    @Serializable
    object CartScreen : Routes()
    @Serializable
    object ProfileScreen : Routes()
    @Serializable
    object FavouritesScreen : Routes()
    @Serializable
    object CheckoutScreen : Routes()
    @Serializable
    data object OrderSuccessScreen

    @Serializable
    data object OrderHistoryScreen

    @Serializable
    data class OrderDetailsScreen(
        val orderId: String
    )

}




