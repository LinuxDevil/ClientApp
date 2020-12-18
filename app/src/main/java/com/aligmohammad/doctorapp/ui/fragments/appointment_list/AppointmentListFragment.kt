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

package com.aligmohammad.doctorapp.ui.fragments.appointment_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.AppointmentListFragmentBinding
import com.aligmohammad.doctorappclient.ui.adapters.AppointmentRecyclerViewAdapter
import com.aligmohammad.doctorappclient.ui.adapters.InProgressAppointmentRecyclerViewAdapter

class AppointmentListFragment : Fragment() {

    private lateinit var viewModel: AppointmentListViewModel
    private lateinit var binding: AppointmentListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.appointment_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(AppointmentListViewModel::class.java)

        initRecycler()

        binding.historyButton.setOnClickListener {
            binding.appointmentList.apply {
                adapter = AppointmentRecyclerViewAdapter(viewModel.provideList(), 0)
            }
        }

        binding.inProgressButton.setOnClickListener {
            binding.appointmentList.apply {
                adapter = InProgressAppointmentRecyclerViewAdapter(viewModel.provideList(), 1)
            }
        }

        return binding.root
    }

    private fun initRecycler() {
        binding.appointmentList.apply {
            adapter = AppointmentRecyclerViewAdapter(viewModel.provideList())
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

}