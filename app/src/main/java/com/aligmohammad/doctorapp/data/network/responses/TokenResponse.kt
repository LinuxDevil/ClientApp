package com.aligmohammad.doctorapp.data.network.responses

import com.aligmohammad.doctorapp.data.model.Status

data class TokenResponse(
    val status: Status,
    val token: String
)
