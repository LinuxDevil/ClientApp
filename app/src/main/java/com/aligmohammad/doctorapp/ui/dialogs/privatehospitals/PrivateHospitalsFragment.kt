package com.aligmohammad.doctorapp.ui.dialogs.privatehospitals

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
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
        val binding: PrivateHospitalsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.private_hospitals_fragment, container, false)
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
        if (navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.doctors?.size!! > 0) {

            val navController = Navigation.findNavController(requireActivity(), R.id.fragment)
            if (navController.currentDestination?.id == R.id.privateHospitalsFragment && navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.size > 1)
                when (view.id) {
                    R.id.operations -> {
                        navigateSafe(
                            PrivateHospitalsFragmentDirections.privateToOperations(
                                navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.doctors?.get(
                                    0
                                )!!
                            )
                                .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                                .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                                .setDoctorShifts(arrayOf("Morning", "After noon"))
                                .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                        )
                    }
                    R.id.external -> this.navigateSafe(
                        PrivateHospitalsFragmentDirections.privateToExternal(
                            navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.doctors?.get(
                                0
                            )!!
                        )
                            .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                            .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                            .setDoctorShifts(arrayOf("Morning", "After noon"))
                            .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                    )
                    R.id.labs -> {
                        this.navigateSafe(
                            PrivateHospitalsFragmentDirections.privateToLabs()
                                .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                                .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                                .setDoctorShifts(arrayOf("Morning", "After noon"))
                                .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                                .setHospitalId(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.id.toString())
                        )
                    }
                    R.id.xray -> this.navigateSafe(
                        PrivateHospitalsFragmentDirections.privateToXRay()
                            .setDates(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentDates!!.toTypedArray())
                            .setTimes(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.appointmentTimes!!.toTypedArray())
                            .setDoctorShifts(arrayOf("Morning", "After noon"))
                            .setLocation(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.nameEn)
                            .setHospitalId(navArgs<PrivateHospitalsFragmentArgs>().value.hospital!!.id.toString())
                    )
                    R.id.naturalist -> this.navigateSafe(
                        PrivateHospitalsFragmentDirections.privateToNaturalist()
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
        } else {
            Toast.makeText(
                requireContext(),
                "Please select a hospital that got doctors",
                Toast.LENGTH_LONG
            ).show()
        }

    }

}