package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.firebasemodels.AppointmentFirebaseModel
import com.aligmohammad.doctorapp.databinding.InProgressAppointmentBinding
import com.aligmohammad.doctorapp.ui.fragments.appointment_list.AppointmentListFragmentDirections
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class InProgressAppointmentRecyclerViewAdapter(
    private var appointments: List<AppointmentFirebaseModel>,
    val type: Int = 0
) : RecyclerView.Adapter<InProgressAppointmentRecyclerViewAdapter.InProgressAppointmentViewHolder>(),
    OnMenuItemClick {

    private var currentItem: AppointmentFirebaseModel? = null

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


        binding.moreButton.setOnClickListener { v ->
            Navigation.findNavController(v)
                .navigate(AppointmentListFragmentDirections.listToDetails(currentItem!!))
        }

        binding.cancelButton.setOnClickListener {
            if (currentItem != null) {
                cancelAppointment(currentItem!!.uuid!!)
            }
        }

        return InProgressAppointmentViewHolder(binding)
    }

    private fun cancelAppointment(tag: String) {
        val appointment = appointments.filter {
            it.uuid == tag
        }[0]
        val db = Firebase.database.reference
        db.child("Appointments").child(appointment.uuid!!).removeValue()
        db.child("Users").child(appointment.userId!!.substring(1, appointment.userId!!.length)).child("Appointments")
            .child(appointment.uuid!!).removeValue()
        if (appointment.doctorId != null && appointment.doctorId!!.isNotEmpty()) {
            db.child("Doctors").child(appointment.doctorId!!).child("Appointments")
                .child(appointment.uuid!!).removeValue()
        } else {
            db.child("Places/Labs").child(appointment.doctorId!!).child("Appointments")
                .child(appointment.uuid!!).removeValue()
            db.child("Places/X-Rays").child(appointment.doctorId!!).child("Appointments")
                .child(appointment.uuid!!).removeValue()
        }
        val arr = appointments.toMutableList()
        arr.remove(appointment)
        appointments = arr.toList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: InProgressAppointmentViewHolder, position: Int) {
        holder.appointmentItemBinding.root.tag = appointments[position].uuid
        holder.appointmentItemBinding.data = appointments[position]
        currentItem = appointments[position]
    }

    override fun getItemCount(): Int = appointments.size

    inner class InProgressAppointmentViewHolder(val appointmentItemBinding: InProgressAppointmentBinding) :
        RecyclerView.ViewHolder(appointmentItemBinding.root)

    override fun onClick(v: View) {
        val appointment = appointments.filter {
            it.userId == v.tag.toString()
        }[0]

        Navigation.findNavController(v)
            .navigate(AppointmentListFragmentDirections.listToDetails(appointment))
    }
}