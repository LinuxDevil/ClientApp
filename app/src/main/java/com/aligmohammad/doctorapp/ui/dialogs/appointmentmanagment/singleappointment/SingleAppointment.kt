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

package com.aligmohammad.doctorapp.ui.dialogs.appointmentmanagment.singleappointment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.SingleAppointmentFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DateRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.TimeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SingleAppointment : BottomSheetDialogFragment(), OnDialogInteract {

    private lateinit var viewModel: SingleAppointmentViewModel
    private lateinit var binding: SingleAppointmentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.single_appointment_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(SingleAppointmentViewModel::class.java)
        binding.viewModel = viewModel
        binding.listener = this
        initializeRecycler()

        binding.dayTime.setOnClickListener {
            binding.nightTime.background = null
            binding.dayTime.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.active_drawable)
        }
        binding.nightTime.setOnClickListener {
            binding.dayTime.background = null
            binding.nightTime.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.active_drawable)
        }

        return binding.root
    }

    private fun initializeRecycler() {
        binding.dateRecyclerView.apply {
            adapter = DateRecyclerAdapter(viewModel.getDates())
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.timeRecyclerView.apply {
            adapter = TimeRecyclerAdapter(viewModel.getTimes())
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onBackButtonClicked(view: View) {
        this.dismiss()
    }

}