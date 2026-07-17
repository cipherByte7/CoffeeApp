package com.example.coffeeapp.data.mapper

import com.example.coffeeapp.data.remote.OrderDto
import com.example.coffeeapp.domain.model.Order
import kotlin.collections.map

fun OrderDto.toOrder(): Order {

    return Order(
        id = id,
        items = items.map { it.toCartItem() },
        totalAmount = totalAmount,
        paymentMode = paymentMode,
        status = status,
        createdAt = createdAt
    )

}