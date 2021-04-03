package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.PlaceRepository
import com.aligmohammad.doctorapp.data.network.responses.DoctorResponse
import com.aligmohammad.doctorapp.data.network.responses.PlaceResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Doctor list view model
 *
 * @property repository
 * @constructor Create empty Doctor list view model
 */
class DoctorListViewModel @ViewModelInject constructor(private val repository: PlaceRepository) :
    BaseViewModel(repository) {

    private val _placeListResponse: MutableLiveData<Resource<PlaceResponse>> =
        MutableLiveData()
    val placeListResponse: LiveData<Resource<PlaceResponse>> get() = _placeListResponse

    private val _doctorListResponse: MutableLiveData<Resource<DoctorResponse>> =
        MutableLiveData()
    val doctorListResponse: LiveData<Resource<DoctorResponse>> get() = _doctorListResponse

    fun getPlaceList(city: String, type: String) = viewModelScope.launch {
        _placeListResponse.value = Resource.Loading
        _placeListResponse.value = repository.getFilteredPlaces(city, type)
    }

    fun getDoctorListFilter() = viewModelScope.launch {
        _doctorListResponse.value = Resource.Loading
        _doctorListResponse.value = repository.getDoctorList()
    }

}