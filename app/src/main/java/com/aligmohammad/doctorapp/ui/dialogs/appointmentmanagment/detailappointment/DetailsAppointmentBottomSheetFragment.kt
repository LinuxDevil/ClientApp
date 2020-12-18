/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

package com.aligmohammad.doctorapp.ui.dialogs.appointmentmanagment.detailappointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.DetailsAppointmentBottomSheetFragmentBinding
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailsAppointmentBottomSheetFragment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: DetailsAppointmentBottomSheetViewModel
    private lateinit var binding: DetailsAppointmentBottomSheetFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.details_appointment_bottom_sheet_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(DetailsAppointmentBottomSheetViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this
        binding.appointment = navArgs<DetailsAppointmentBottomSheetFragmentArgs>().value.appointment
        return binding.root
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

}