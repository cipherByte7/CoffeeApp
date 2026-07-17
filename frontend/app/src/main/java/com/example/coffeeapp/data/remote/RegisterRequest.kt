package com.example.coffeeapp.data.remote

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)