package com.example.coffeeapp.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://coffee-backend-api-z6zm.onrender.com/"

    private var authToken: String? = null

    fun setToken(token: String?) {
        authToken = token
    }

    private val client by lazy {

        OkHttpClient.Builder()
            .addInterceptor(
                AuthInterceptor {
                    authToken
                }
            )
            .build()

    }

    val api: CoffeeApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoffeeApi::class.java)

    }

}