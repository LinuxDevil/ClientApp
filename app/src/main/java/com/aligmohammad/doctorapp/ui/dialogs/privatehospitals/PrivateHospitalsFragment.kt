package com.aligmohammad.doctorapp.ui.dialogs.privatehospitals

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.PrivateHospitalsFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import navigateSafe

class PrivateHospitalsFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: PrivateHospitalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: PrivateHospitalsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.private_hospitals_fragment, container, false)
        viewModel = ViewModelProvider(this).get(PrivateHospitalsViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        Log.v("MainActivity", "onButtonClicked")
        val navController = Navigation.findNavController(activity!!, R.id.fragment)
        if (navController.currentDestination?.id == R.id.privateHospitalsFragment)
            when (view.id) {
                R.id.operations -> this.navigateSafe(PrivateHospitalsFragmentDirections.privateToOperations())
                R.id.external ->  this.navigateSafe(PrivateHospitalsFragmentDirections.privateToExternal())
                R.id.labs -> this.navigateSafe(PrivateHospitalsFragmentDirections.privateToLabs())
                R.id.xray -> this.navigateSafe(PrivateHospitalsFragmentDirections.privateToXRay())
                R.id.naturalist -> this.navigateSafe(PrivateHospitalsFragmentDirections.privateToNaturalist())
                else -> return
            }
        else {
            Log.v("MainActivity", navController.currentDestination?.label.toString())
        }

    }

}