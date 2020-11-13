package com.aligmohammad.doctorapp

import android.app.Application
import com.aligmohammad.doctorapp.data.api.AuthApi
import com.aligmohammad.doctorapp.data.api.DoctorApi
import com.aligmohammad.doctorapp.data.api.NetworkInterceptor
import com.aligmohammad.doctorapp.data.database.AppDatabase
import com.aligmohammad.doctorapp.data.repository.AuthRepository
import com.aligmohammad.doctorapp.helpers.DataStoreHelper
import com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModelFactory
import com.aligmohammad.doctorapp.ui.fragments.homefragment.HomeFragmentViewModelFactory
import com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceViewModelFactory
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule

class DoctorApplication : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@DoctorApplication))

        bind() from singleton { NetworkInterceptor(instance()) }
        bind() from singleton { AuthApi(instance()) }
        bind() from singleton { DoctorApi(instance()) }

        bind() from singleton { DataStoreHelper(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { AuthRepository(instance(), instance()) }

        bind() from provider { BaseViewModel(instance()) }
        bind() from provider { AuthViewModelFactory(instance(), instance()) }

        bind() from provider { InsuranceViewModelFactory(instance()) }
        bind() from provider { HomeFragmentViewModelFactory(instance()) }

    }

}