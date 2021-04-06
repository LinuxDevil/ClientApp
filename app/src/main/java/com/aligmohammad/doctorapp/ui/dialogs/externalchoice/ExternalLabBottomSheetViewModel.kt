package com.aligmohammad.doctorapp.ui.dialogs.externalchoice

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.dto.AppointmentDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.HospitalRepository
import com.aligmohammad.doctorapp.data.network.responses.AppointmentResponse
import com.aligmohammad.doctorapp.data.network.responses.DoctorAppointment
import com.aligmohammad.doctorapp.data.network.responses.HospitalAppointment
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ExternalLabBottomSheetViewModel @ViewModelInject constructor(private val hospitalRepository: HospitalRepository) :
    BaseViewModel(hospitalRepository) {

    private val _addGeneralAppointmentResponse: MutableLiveData<Resource<HospitalAppointment>> =
        MutableLiveData()
    val addGeneralAppointmentResponse: LiveData<Resource<HospitalAppointment>>
        get() = _addGeneralAppointmentResponse

    private val _addAppointmentResponse: MutableLiveData<Resource<DoctorAppointment>> =
        MutableLiveData()
    val addAppointmentResponse: LiveData<Resource<DoctorAppointment>>
        get() = _addAppointmentResponse

    fun addHospitalDoctorAppointment(appointment: AppointmentDTO) = viewModelScope.launch {
        _addAppointmentResponse.value = Resource.Loading
        _addAppointmentResponse.value = hospitalRepository.addHospitalDoctorAppointment(appointment)
    }

    fun addHospitalGeneralAppointment(appointment: AppointmentDTO) = viewModelScope.launch {
        _addGeneralAppointmentResponse.value = Resource.Loading
        _addGeneralAppointmentResponse.value =
            hospitalRepository.addGeneralHospitalAppointment(appointment)
    }

}