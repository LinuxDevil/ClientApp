package com.aligmohammad.doctorapp.ui.dialogs.govermenthospitals

import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModel
import com.aligmohammad.doctorapp.R

class GovernmentHospitalsViewModel : ViewModel() {

    fun onChoiceClicked(view: View) {
        when ((view as Button).text.toString()) {
            R.string.external.toString() -> return
            R.string.labs.toString() -> return
            R.string.x_ray.toString() -> return
            R.string.naturalist.toString() -> return
            else -> return
        }
    }

}