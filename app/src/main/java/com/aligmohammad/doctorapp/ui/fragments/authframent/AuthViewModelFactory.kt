package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.data.repository.AuthRepository

class AuthViewModelFactory(private val repository: AuthRepository, private val application: Application): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository, application) as T
    }

}