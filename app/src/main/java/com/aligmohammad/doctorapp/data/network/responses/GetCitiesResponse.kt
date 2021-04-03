package com.aligmohammad.doctorapp.data.network.responses

data class GetCitiesResponse(
    val cities: List<String>,
    val length: Int,
    val status: Status
)
