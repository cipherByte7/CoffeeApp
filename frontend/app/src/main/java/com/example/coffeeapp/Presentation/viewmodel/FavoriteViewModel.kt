package com.example.coffeeapp.Presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.data.repository.CoffeeRepository
import com.example.coffeeapp.domain.model.Product
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val repository = CoffeeRepository()

    var favorites by mutableStateOf<List<Product>>(emptyList())
        private set

    var favoriteIds by mutableStateOf<Set<String>>(emptySet())
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        loadFavorites()
    }

    fun loadFavorites() {

        viewModelScope.launch {

            isLoading = true

            favorites = repository.getFavorites()

            favoriteIds = favorites.map {
                it.id
            }.toSet()

            isLoading = false

        }

    }

    fun toggleFavorite(productId: String) {

        viewModelScope.launch {

            repository.toggleFavorite(productId)

            loadFavorites()

        }

    }

    fun isFavorite(productId: String): Boolean {

        return favoriteIds.contains(productId)

    }
}

