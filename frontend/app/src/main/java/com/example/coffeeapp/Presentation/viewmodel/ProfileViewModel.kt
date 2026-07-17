package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.User
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    var user by mutableStateOf<User?>(null)
        private set

    init {
        loadProfile()
    }

    private fun loadProfile() {

        viewModelScope.launch {

            user = repository.getProfile()

        }

    }

}