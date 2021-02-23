



package com.aligmohammad.doctorapp.ui.dialogs.govermenthospitals

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.GovernmentHospitalsFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import navigateSafe

class GovernmentHospitalsFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: GovernmentHospitalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GovernmentHospitalsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.government_hospitals_fragment, container, false)
        viewModel = ViewModelProvider(this).get(GovernmentHospitalsViewModel::class.java)
        binding.listener = this
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        Log.v("MainActivity", "onButtonClicked")
        val navController = Navigation.findNavController(activity!!, R.id.fragment)
        if (navController.currentDestination?.id == R.id.governmentHospitalsFragment)
            when (view.id) {
                R.id.external ->  this.navigateSafe(GovernmentHospitalsFragmentDirections.governmentToExternal())
                R.id.labs -> this.navigateSafe(GovernmentHospitalsFragmentDirections.governmentToLabs())
                R.id.xray -> this.navigateSafe(GovernmentHospitalsFragmentDirections.governmentToXRay())
                R.id.naturalist -> this.navigateSafe(GovernmentHospitalsFragmentDirections.governmentToNaturalist())
                else -> return
            }
        else {
            Log.v("MainActivity", navController.currentDestination?.label.toString())
        }

    }

}