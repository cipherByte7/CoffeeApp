package com.example.coffeeapp.data.repository

import com.example.coffeeapp.data.remote.LoginRequest
import com.example.coffeeapp.data.remote.LoginResponse
import com.example.coffeeapp.data.remote.RegisterRequest
import com.example.coffeeapp.data.remote.RegisterResponse
import com.example.coffeeapp.data.remote.RetrofitInstance

class AuthRepository {

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): RegisterResponse? {

        return try {

            val response = RetrofitInstance.api.register(
                RegisterRequest(
                    name,
                    email,
                    password
                )
            )

            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }

        } catch (e: Exception) {
            null
        }
    }

    suspend fun login(
        email: String,
        password: String
    ): LoginResponse? {

        return try {

            val response = RetrofitInstance.api.login(
                LoginRequest(
                    email,
                    password
                )
            )

            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }

        } catch (e: Exception) {
            null
        }
    }
}
