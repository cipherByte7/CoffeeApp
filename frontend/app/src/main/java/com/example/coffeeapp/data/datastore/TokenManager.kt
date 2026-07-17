package com.example.coffeeapp.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore("auth_pref")

class TokenManager(
    private val context: Context
) {

    companion object {

        private val TOKEN_KEY =
            stringPreferencesKey("jwt_token")

    }

    suspend fun saveToken(token: String) {

        context.dataStore.edit { preferences ->

            preferences[TOKEN_KEY] = token

        }

    }

    val token: Flow<String?> =

        context.dataStore.data.map { preferences ->

            preferences[TOKEN_KEY]

        }

    suspend fun clearToken() {

        context.dataStore.edit {

            it.remove(TOKEN_KEY)

        }

    }

    suspend fun getToken(): String? {
        return token.first()
    }



}