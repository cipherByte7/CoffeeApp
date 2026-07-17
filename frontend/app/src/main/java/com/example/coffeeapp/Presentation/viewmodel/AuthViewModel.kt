package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.remote.LoginResponse
import com.example.coffeeapp.data.remote.RegisterResponse
import com.example.coffeeapp.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository()

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var loginResponse by mutableStateOf<LoginResponse?>(null)
        private set

    var registerResponse by mutableStateOf<RegisterResponse?>(null)
        private set

    fun register(
        name: String,
        email: String,
        password: String
    ) {

        viewModelScope.launch {

            isLoading = true
            errorMessage = null

            registerResponse = repository.register(
                name,
                email,
                password
            )

            if (registerResponse == null) {
                errorMessage = "Registration Failed"
            }

            isLoading = false
        }

    }

    fun login(
        email: String,
        password: String
    ) {

        viewModelScope.launch {

            isLoading = true
            errorMessage = null

            loginResponse = repository.login(
                email,
                password
            )

            if (loginResponse == null) {
                errorMessage = "Login Failed"
            }

            isLoading = false
        }

    }

}