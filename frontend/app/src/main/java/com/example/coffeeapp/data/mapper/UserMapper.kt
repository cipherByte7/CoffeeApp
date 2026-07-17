package com.example.coffeeapp.data.mapper

import com.example.coffeeapp.data.remote.UserDto
import com.example.coffeeapp.domain.model.User

fun UserDto.toUser(): User {

    return User(
        id = id,
        name = name,
        email = email
    )

}