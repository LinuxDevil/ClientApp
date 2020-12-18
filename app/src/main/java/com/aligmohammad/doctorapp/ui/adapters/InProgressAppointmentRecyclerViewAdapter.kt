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

package com.aligmohammad.doctorappclient.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Appointment
import com.aligmohammad.doctorapp.databinding.InProgressAppointmentBinding
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.appointment_list.AppointmentListFragmentDirections

class InProgressAppointmentRecyclerViewAdapter(
    private val appointments: List<Appointment>,
    val type: Int = 0
) : RecyclerView.Adapter<InProgressAppointmentRecyclerViewAdapter.InProgressAppointmentViewHolder>(),
    OnMenuItemClick {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InProgressAppointmentViewHolder {

        val binding: InProgressAppointmentBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.in_progress_appointment,
            parent,
            false
        )
        binding.listener = this
        return InProgressAppointmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InProgressAppointmentViewHolder, position: Int) {
        holder.appointmentItemBinding.data = appointments[position]
    }

    override fun getItemCount(): Int = appointments.size

    inner class InProgressAppointmentViewHolder(val appointmentItemBinding: InProgressAppointmentBinding) :
        RecyclerView.ViewHolder(appointmentItemBinding.root)

    override fun onClick(v: View) {
        val appointment = appointments.filter {
            it.patient?.name == v.tag.toString()
        }[0]

        Navigation.findNavController(v)
            .navigate(AppointmentListFragmentDirections.listToDetails(appointment))
    }
}