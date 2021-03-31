package com.aligmohammad.doctorapp.data.network.response

class PlaceListResponse : ArrayList<PlaceListResponseItem>()

data class PlaceListResponseItem(
    val appointmentDates: List<String>,
    val appointmentDurations: List<String>,
    val appointmentTimes: List<String>,
    val appointments: List<Any>,
    val bio: String,
    val created: String,
    val duration: String,
    val email: String,
    val hospital: Hospital,
    val id: Int,
    val image: String,
    val insuranceCompany: InsuranceCompany,
    val insuranceNumber: String,
    val isVerified: Boolean,
    val name: String,
    val nationalityId: String,
    val patients: List<Any>,
    val phone: String,
    val qalifications: List<Any>,
    val shiftDuration: Int,
    val updated: String,
    val username: String
)

data class Hospital(
    val appointmentDates: List<String>,
    val appointmentDurations: List<String>,
    val appointmentTimes: List<String>,
    val created: String,
    val duration: String,
    val email: String,
    val endTime: String,
    val holidays: List<String>,
    val id: Int,
    val imageUrl: String,
    val insurances: List<String>,
    val isAvialable: Boolean,
    val nameAr: String,
    val nameEn: String,
    val phone: String,
    val shiftDuration: Int,
    val startTime: String,
    val type: String,
    val updated: String
)
