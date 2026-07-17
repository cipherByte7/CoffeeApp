package com.example.coffeeapp.data.remote

data class CartDto(

    val _id: String,
    val product: ProductDto,
    val quantity: Int
)