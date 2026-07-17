package com.example.coffeeapp.data.remote

data class OrderItemDto(

    val product: ProductDto,
    val quantity: Int,
    val price: Double

)