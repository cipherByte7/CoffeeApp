package com.example.coffeeapp.data.mapper

import com.example.coffeeapp.data.remote.CartDto
import com.example.coffeeapp.domain.model.CartItem

fun CartDto.toCartItem(): CartItem {

    return CartItem(
        id = _id,
        product = product.toProduct(),
        quantity = quantity
    )
}