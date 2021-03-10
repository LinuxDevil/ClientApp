package com.aligmohammad.doctorapp.data.network.repository

import com.aligmohammad.doctorapp.data.model.nest.AddAppointment
import com.aligmohammad.doctorapp.data.network.api.HospitalApi
import javax.inject.Inject

class HospitalRepository @Inject constructor(
    private val api: HospitalApi
) : BaseRepository(api) {

    suspend fun getPrivateHospitals() = safeApiCall {
        api.getPrivateHospitals()
    }

    suspend fun getGeneralHospitals() = safeApiCall {
        api.getGeneralHospitals()
    }

    suspend fun getFilteredPrivateHospitals(city: String) = safeApiCall {
        api.getFilteredPrivateHospitals(city)
    }

    suspend fun getFilteredGeneralHospitals(city: String) = safeApiCall {
        api.getFilteredGenernalHospitals(city)
    }

    suspend fun addHospitalDoctorAppointment(addAppointment: AddAppointment) = safeApiCall {
        api.addHospitalDoctorAppointment(addAppointment)
    }

    suspend fun addGeneralHospitalAppointment(addAppointment: AddAppointment) = safeApiCall {
        api.addGeneralHospitalAppointment(addAppointment)
    }

}