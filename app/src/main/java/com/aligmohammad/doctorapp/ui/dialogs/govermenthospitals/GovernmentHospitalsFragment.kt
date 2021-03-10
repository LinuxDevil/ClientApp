package com.aligmohammad.doctorapp.ui.dialogs.govermenthospitals

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.GovernmentHospitalsFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.aligmohammad.doctorapp.ui.dialogs.privatehospitals.PrivateHospitalsFragmentArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import navigateSafe

class GovernmentHospitalsFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: GovernmentHospitalsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GovernmentHospitalsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.government_hospitals_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(GovernmentHospitalsViewModel::class.java)
        binding.listener = this
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

    override fun onButtonClicked(view: View) {
        Log.v("MainActivity", "onButtonClicked")
        val navController = Navigation.findNavController(requireActivity(), R.id.fragment)
        if (navController.currentDestination?.id == R.id.governmentHospitalsFragment)
            when (view.id) {
                R.id.external -> this.navigateSafe(
                    GovernmentHospitalsFragmentDirections.governmentToExternal(
                        navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.doctors?.get(
                            0
                        )!!
                    )
                        .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                        .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                        .setDoctorShifts(arrayOf("Morning", "After noon"))
                        .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                )
                R.id.labs -> this.navigateSafe(
                    GovernmentHospitalsFragmentDirections.governmentToLabs()
                        .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                        .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                        .setDoctorShifts(arrayOf("Morning", "After noon"))
                        .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                        .setHospitalId(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.id.toString())
                )
                R.id.xray -> this.navigateSafe(
                    GovernmentHospitalsFragmentDirections.governmentToXRay()
                        .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                        .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                        .setDoctorShifts(arrayOf("Morning", "After noon"))
                        .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                        .setHospitalId(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.id.toString())
                )
                R.id.naturalist -> this.navigateSafe(
                    GovernmentHospitalsFragmentDirections.governmentToNaturalist()
                        .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                        .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                        .setDoctorShifts(arrayOf("Morning", "After noon"))
                        .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                        .setHospitalId(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.id.toString())
                )
                else -> return
            }
        else {
            Log.v("MainActivity", navController.currentDestination?.label.toString())
        }

    }

}