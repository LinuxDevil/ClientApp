package com.aligmohammad.doctorapp.ui.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.data.repository.AuthRepository
import com.aligmohammad.doctorapp.ui.fragments.AuthViewModel

class AuthViewModelFactory(private val repository: AuthRepository, private val application: Application): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository, application) as T
    }

}