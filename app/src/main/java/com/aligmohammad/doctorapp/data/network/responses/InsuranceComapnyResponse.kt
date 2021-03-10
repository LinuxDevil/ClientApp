package com.aligmohammad.doctorapp.data.network.responses

data class InsuranceCompanyResponse(
    val insurances: List<Insurance>
)

data class Insurance(
    val created: String,
    val id: Int,
    val nameAr: String,
    val nameEn: String,
    val type: String,
    val updated: String
)