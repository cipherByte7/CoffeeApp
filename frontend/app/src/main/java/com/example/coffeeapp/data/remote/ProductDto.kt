package com.example.coffeeapp.data.remote

import com.google.gson.annotations.SerializedName

data class ProductDto(

    @SerializedName("_id")
    val id: String,

    val name: String,

    val description: String,

    val price: Double,

    val image: String,

    val category: String
)