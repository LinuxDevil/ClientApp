package com.aligmohammad.doctorapp.ui.fragments.doctorplaces

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.DoctorPlaceRepository
import com.aligmohammad.doctorapp.data.network.responses.DoctorPlaceResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class DoctorPlacesViewModel @ViewModelInject constructor(private val repository: DoctorPlaceRepository) :
    BaseViewModel(repository) {

    val _doctorResponse: MutableLiveData<Resource<DoctorPlaceResponse>> = MutableLiveData()
    val doctorResponse: LiveData<Resource<DoctorPlaceResponse>> get() = _doctorResponse

    fun getPlaces() = viewModelScope.launch {
        _doctorResponse.value = Resource.Loading
        _doctorResponse.value = repository.getDoctorPlaces()
    }

}