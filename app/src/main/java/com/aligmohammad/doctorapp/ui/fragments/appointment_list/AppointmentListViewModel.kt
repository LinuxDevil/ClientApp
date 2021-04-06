

package com.aligmohammad.doctorapp.ui.fragments.appointment_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aligmohammad.doctorapp.data.model.Appointment
import com.aligmohammad.doctorapp.data.model.dto.UserLoginData
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.UserRepository
import com.aligmohammad.doctorapp.data.network.responses.UserAppointments
import com.aligmohammad.doctorapp.ui.base.BaseViewModel

class AppointmentListViewModel @ViewModelInject constructor(private val userRepository: UserRepository) :
    BaseViewModel(userRepository) {

    private val _appointmentsLiveDataResponse: MutableLiveData<Resource<UserAppointments>> =
        MutableLiveData()
    val appointmentsLiveData: LiveData<Resource<UserAppointments>> get() = _appointmentsLiveDataResponse

    suspend fun getUserAppointments(username: String) {
        userRepository.getUserCurrentAppointments(username)
    }


}