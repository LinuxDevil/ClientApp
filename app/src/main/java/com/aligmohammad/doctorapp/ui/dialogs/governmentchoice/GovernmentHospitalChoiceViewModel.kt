package com.aligmohammad.doctorapp.ui.dialogs.governmentchoice

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

class GovernmentHospitalChoiceViewModel: ViewModel() {

    fun onConfirmClicked(view: View) {
        Navigation.findNavController(view).navigate(GovernmentHospitalChoiceDirections.govChoiceToGovHospitals())
    }

}