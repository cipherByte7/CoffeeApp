package com.example.coffeeapp.data.remote

import com.google.gson.annotations.SerializedName

data class OrderDto(
    @SerializedName("_id")
    val id: String,

    val items: List<OrderItemDto>,

    val totalAmount: Double,

    val paymentMode: String,

    val status: String,

    val createdAt: String
)
