package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligmohammad.doctorapp.data.model.UserDTO
import com.aligmohammad.doctorapp.data.model.UserInfoModel
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.repository.UserRepository
import com.aligmohammad.doctorapp.data.network.response.User
import com.aligmohammad.doctorapp.data.network.responses.FirebaseUserResponse
import com.aligmohammad.doctorapp.data.network.responses.LoginResponse
import com.aligmohammad.doctorapp.data.network.responses.UserInfoResponse
import com.aligmohammad.doctorapp.ui.base.BaseViewModel
import com.aligmohammad.doctorapp.util.snackbar
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class NationalIDViewModel @ViewModelInject constructor(private val repository: UserRepository) :
    BaseViewModel(repository) {

    private val _userInfoResponse: MutableLiveData<Resource<User>> = MutableLiveData()
    val userResponse: LiveData<Resource<User>>
        get() = _userInfoResponse

    fun updateUser(userDto: UserDTO) = viewModelScope.launch {
        _userInfoResponse.value = Resource.Loading
        _userInfoResponse.value = repository.updateUser(userDto)
    }

}