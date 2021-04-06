package com.aligmohammad.doctorapp.ui.fragments.doctorprofile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.DoctorProfileFragmentBinding
import kotlinx.android.synthetic.main.doctor_profile_fragment.view.*
import navigateSafe

class DoctorProfileFragment : Fragment() {

    private lateinit var viewModel: DoctorProfileViewModel
    private lateinit var binding: DoctorProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.doctor_profile_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DoctorProfileViewModel::class.java)

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        binding.root.confirm_button.setOnClickListener {
            val navController = Navigation.findNavController(requireActivity(), R.id.fragment)
            if (navController.currentDestination?.id == R.id.doctorProfileFragment)
                if (binding.doctor != null) {
                    val doc = binding.doctor!!
                    this.navigateSafe(
                        DoctorProfileFragmentDirections.doctorToAppointment(doc.id.toString())
                        .setDates(doc.appointmentDates!!.toTypedArray())
                        .setTimes(doc.appointmentTimes!!.toTypedArray())
                        .setDoctorShifts(arrayOf("Morning","Night"))
                    )
                }

            else {
                Log.v("MainActivity", navController.currentDestination?.label.toString())
            }
        }

        arguments?.let {
            binding.doctor = DoctorProfileFragmentArgs.fromBundle(it).doctor
        }

        return binding.root
    }


}