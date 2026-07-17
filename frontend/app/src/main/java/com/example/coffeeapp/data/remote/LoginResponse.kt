package com.example.coffeeapp.data.remote

data class LoginResponse(
    val message: String,
    val token: String,
    val user: UserDto
)
