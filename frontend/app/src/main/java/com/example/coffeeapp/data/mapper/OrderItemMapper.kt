package com.example.coffeeapp.data.mapper

import com.example.coffeeapp.data.remote.OrderItemDto
import com.example.coffeeapp.domain.model.CartItem

fun OrderItemDto.toCartItem(): CartItem {

    return CartItem(

        id = "",

        product = product.toProduct(),

        quantity = quantity

    )

}