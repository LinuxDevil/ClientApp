package com.aligmohammad.doctorapp.data.model

data class RequestDoctor(
    val insuranceCompany: String?,
    val city: String?,
    val district: String?,
    val doctorMajor: String?,
    val total: Int?,
    val deliveryFee: Int?,
    val patientId: String?
)