package com.aligmohammad.doctorapp.data.network.responses

data class MajorResponse(
    val majors: List<Major>,
    val status: Status
)

data class Major(
    val created: String,
    val id: Int,
    val imageUrl: String,
    val nameAr: String,
    val nameEn: String,
    val updated: String,
    val doctors: List<Doctor>?
)
