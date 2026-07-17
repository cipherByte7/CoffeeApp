package com.example.coffeeapp.domain.model

data class Order(
    val id: String,
    val items: List<CartItem>,
    val totalAmount: Double,
    val paymentMode: String,
    val status: String,
    val createdAt: String
)