package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.User

data class LoginResponse(
    val status: Status,
    val user: User
)
