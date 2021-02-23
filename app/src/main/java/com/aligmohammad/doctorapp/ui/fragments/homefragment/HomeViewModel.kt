package com.aligmohammad.doctorapp.ui.fragments.homefragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.RecyclerMenuItem
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.HomeRepository
import com.aligmohammad.doctorapp.data.network.response.MenuItemResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(private val repository: HomeRepository) :
    BaseViewModel(repository) {

    private val _menuItems: MutableLiveData<Resource<MenuItemResponse>> = MutableLiveData()
    val menuItemReponse: LiveData<Resource<MenuItemResponse>>
        get() = _menuItems

    private val _subMenuItems: MutableLiveData<Resource<MenuItemResponse>> = MutableLiveData()
    val subMenuItemResponse: LiveData<Resource<MenuItemResponse>>
        get() = _subMenuItems

    fun getSubMenuItems() = viewModelScope.launch {
        _subMenuItems.value = Resource.Loading
        _subMenuItems.value = repository.getSubMenuItem()
    }

    fun getMenuItems() = viewModelScope.launch {
        _menuItems.value = Resource.Loading
        _menuItems.value = repository.getMenuItem()
    }

}