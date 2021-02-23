package com.aligmohammad.doctorapp.data.network.responses

data class LoginResponse(
    val jwt: String,
    val user: User
)
