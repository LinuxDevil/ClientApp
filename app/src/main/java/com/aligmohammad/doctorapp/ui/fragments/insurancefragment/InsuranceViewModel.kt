package com.aligmohammad.doctorapp.ui.fragments.insurancefragment

import android.app.Application
import android.view.View
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.BaseViewModel

class InsuranceViewModel(application: Application) : BaseViewModel(application){

    fun onConfirmClicked(view: View) {
//        val options =
//        Navigation.findNavController(view).navigate(R.id.insuracneToHome, null, NavOptions.Builder().setPopUpTo(
//            R.id.loginFragment, true).build())

        Navigation.findNavController(view).navigate(InsuranceFragmentDirections.insuracneToHome())

    }


}