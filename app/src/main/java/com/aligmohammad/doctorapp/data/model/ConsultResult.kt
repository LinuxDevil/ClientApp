



package com.aligmohammad.doctorapp.data.model

data class ConsultResult(
    val locationName: String?,
    val lat: Float?,
    val lng: Float?,
    val medicineList: List<Medicine>?,
    val pharmacyId: String,
    val deliveryOption: String?,
    val total: Double?,
    val deliveryFee: Double?
)