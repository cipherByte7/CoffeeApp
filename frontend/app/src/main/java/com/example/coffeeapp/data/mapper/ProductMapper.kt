package com.example.coffeeapp.data.mapper

import com.example.coffeeapp.R
import com.example.coffeeapp.data.remote.ProductDto
import com.example.coffeeapp.domain.model.Product

fun ProductDto.toProduct(): Product {

    return Product(
        id = id,
        name = name,
        description = description,
        price = price,
        imageResourceId = getDrawable(image)
    )
}

private fun getDrawable(image: String): Int {

    return when (image) {

        "espresso.png" -> R.drawable.macchiato
        "cappuccino.png" -> R.drawable.cappuccino
        "latte.png" -> R.drawable.latte
        "mocha.png" -> R.drawable.mocha
        "macchiato.png" -> R.drawable.macchiato
        "iced_coffee.png" -> R.drawable.iced_coffee
        "hot_chocolate.png" -> R.drawable.hot_chocolate
        "americano.png" -> R.drawable.americano
        "flat_white.png" -> R.drawable.macchiato
        "vanilla_latte.png" -> R.drawable.macchiato
        "cold_brew.png" -> R.drawable.macchiato
        "iced_mocha.png" -> R.drawable.macchiato
        "hazelnut_latte.png" -> R.drawable.macchiato
        "affogato.png" -> R.drawable.macchiato
        "irish_coffee.png" -> R.drawable.macchiato
        "nitro_cold_brew.png" -> R.drawable.macchiato

        else -> R.drawable.macchiato
    }
}