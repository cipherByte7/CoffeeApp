package com.example.coffeeapp.domain.model

data class CartItem(
    val id: String,
    val product: Product,
    var quantity: Int
)