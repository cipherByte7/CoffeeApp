package com.example.coffeeapp.data.repository

import com.example.coffeeapp.R
import com.example.coffeeapp.domain.model.Product
import kotlin.collections.listOf

class CoffeeRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product(id = 1, "Expresso", "Strong & Rich", 15.99, R.drawable.expresso),
            Product(id = 2, "Cappuccino", "Rich & Creamy", 18.99, R.drawable.cappuccino),
            Product(id = 3, "Latte", "Creamy & Cold", 16.99, R.drawable.latte),
            Product(id = 4, "Mocha", "Espresso & Chocolate", 12.99, R.drawable.mocha),
            Product(id = 5, "Macchiato", "Espresso & Foamed Milk", 11.99, R.drawable.macchiato),
            Product(id = 6, "Iced Coffee", "Cold & Iced", 17.99, R.drawable.iced_coffee),
            Product(id = 7, "Hot Chocolate", "Rich & Creamy", 14.99, R.drawable.hot_chocolate),
            Product(id = 8, "Americano", "Bold & Smooth", 13.99, R.drawable.americano),
            Product(id = 9, "Flat White", "Velvety & Balanced", 16.49, R.drawable.flatwhite),
            Product(id = 10, "Vanilla Latte", "Sweet & Smooth", 18.49, R.drawable.vanilllalatte),
            Product(id = 12, "Cold Brew", "Slow Brewed & Strong", 17.49, R.drawable.coldbrew),
            Product(id = 13, "Iced Mocha", "Cold Chocolate Coffee", 18.99, R.drawable.iced_coffee),
            Product(id = 14, "Hazelnut Latte", "Nutty & Smooth", 19.99, R.drawable.hazzle_nut_latte),
            Product(id = 15, "Affogato", "Espresso & Ice Cream", 20.99, R.drawable.affagato),
            Product(id = 16, "Irish Coffee", "Coffee with Cream", 21.99, R.drawable.irishcoffee),
            Product(id = 17, "Nitro Cold Brew", "Creamy & Fizzy", 22.49, R.drawable.nitrocoldbrew)
        )
    }
}