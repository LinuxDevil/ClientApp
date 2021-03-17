package com.aligmohammad.doctorapp.ui.fragments.armyplaces

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.ArmyPlaceRepository
import com.aligmohammad.doctorapp.data.network.response.ArmyPlaceResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ArmyListViewModel @ViewModelInject constructor(private val repository: ArmyPlaceRepository) :
    BaseViewModel(repository) {

    private val _armyResponse: MutableLiveData<Resource<ArmyPlaceResponse>> = MutableLiveData()
    val armyResponse: LiveData<Resource<ArmyPlaceResponse>> get() = _armyResponse

    fun getPlaces() = viewModelScope.launch {
        _armyResponse.value = Resource.Loading
        _armyResponse.value = repository.getArmyPlaces()
    }

}