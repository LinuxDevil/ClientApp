package com.aligmohammad.doctorapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Consult (
    val consultingIn: String?,
    val temperature: String?,
    val patientID: String?
) {
    @PrimaryKey(autoGenerate = true)
    public var id = 0
}