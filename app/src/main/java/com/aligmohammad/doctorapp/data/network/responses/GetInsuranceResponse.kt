package com.aligmohammad.doctorapp.data.network.responses

data class GetInsuranceResponse(
    val insurances: List<Insurance>,
    val status: Status
)

data class Insurance(
    val created: String,
    val id: Int,
    val nameAr: String,
    val nameEn: String,
    val type: String,
    val updated: String
)

data class Status(
    val message: String,
    val status: Int
)