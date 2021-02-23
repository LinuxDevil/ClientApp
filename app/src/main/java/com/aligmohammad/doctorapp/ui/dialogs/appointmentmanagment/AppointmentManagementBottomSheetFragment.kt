

package com.aligmohammad.doctorapp.ui.dialogs.appointmentmanagment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Appointment
import com.aligmohammad.doctorapp.data.model.firebasemodels.AppointmentFirebaseModel
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.AppointmentManagmentBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AppointmentManagementBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: AppointmentManagmentBottomSheetViewModel
    private lateinit var binding: AppointmentManagmentBottomSheetFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.appointment_managment_bottom_sheet_fragment,
            container,
            false
        )
        viewModel =
            ViewModelProvider(this).get(AppointmentManagmentBottomSheetViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this




        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

}