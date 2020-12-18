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
import com.aligmohammad.doctorapp.databinding.AppointmentItemBinding
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.appointment_list.AppointmentListFragmentDirections

class AppointmentRecyclerViewAdapter(
    private val appointments: List<Appointment>,
    val type: Int = 0
) : RecyclerView.Adapter<AppointmentRecyclerViewAdapter.AppointmentViewHolder>(), OnMenuItemClick {

    var clickIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {

        val binding: AppointmentItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.appointment_item,
            parent,
            false
        )
        binding.listener = this
        return AppointmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        holder.appointmentItemBinding.data = appointments[position]
        clickIndex = position
    }

    override fun getItemCount(): Int = appointments.size

    inner class AppointmentViewHolder(val appointmentItemBinding: AppointmentItemBinding) :
        RecyclerView.ViewHolder(appointmentItemBinding.root)

    override fun onClick(v: View) {
        val appointment = appointments.filter {
            it.patient?.name == v.tag.toString()
        }[0]

        Navigation.findNavController(v)
            .navigate(AppointmentListFragmentDirections.listToDetails(appointment))
    }
}