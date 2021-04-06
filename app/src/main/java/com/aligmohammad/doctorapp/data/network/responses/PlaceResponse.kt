package com.aligmohammad.doctorapp.data.network.responses

data class PlaceResponse(
    val length: Int,
    val places: List<Place>,
    val status: Status,
    val type: String
)

data class Place(
    val appointmentDates: List<String>,
    val appointmentDurations: List<String>,
    val appointmentTimes: List<String>,
    val created: String,
    val doctors: List<Doctor>,
    val duration: String,
    val email: String,
    val endTime: String,
    val holidays: List<String>,
    val id: Int,
    val imageUrl: String,
    val insurances: List<String>,
    val isAvialable: Boolean,
    val location: Location,
    val nameAr: String,
    val nameEn: String,
    val phone: String,
    val shiftDuration: Int,
    val startTime: String,
    val type: String,
    val updated: String
)
