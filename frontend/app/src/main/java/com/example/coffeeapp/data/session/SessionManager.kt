package com.example.coffeeapp.data.session

import com.example.coffeeapp.data.datastore.TokenManager
import com.example.coffeeapp.data.remote.RetrofitInstance

class SessionManager(
    private val tokenManager: TokenManager
) {

    suspend fun initialize() {

        val token = tokenManager.getToken()

        RetrofitInstance.setToken(token)

    }

}
