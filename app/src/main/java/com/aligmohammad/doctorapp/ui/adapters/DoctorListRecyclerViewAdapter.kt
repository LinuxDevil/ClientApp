package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Doctor
import com.aligmohammad.doctorapp.databinding.DoctorListItemBinding
import com.aligmohammad.doctorapp.ui.fragments.doctorlist.DoctorListFragmentDirections

class DoctorListRecyclerViewAdapter(
    private val doctors: List<Doctor>
) : RecyclerView.Adapter<DoctorListRecyclerViewAdapter.DoctorListViewHolder>(), OnMenuItemClick {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorListViewHolder {
        val binding: DoctorListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.doctor_list_item,
            parent,
            false
        )
        binding.listener = this
        return DoctorListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorListViewHolder, position: Int) {
        holder.doctorItemBinding.data = doctors[position]
    }

    override fun getItemCount(): Int = doctors.size

    inner class DoctorListViewHolder(val doctorItemBinding: DoctorListItemBinding) :
        RecyclerView.ViewHolder(doctorItemBinding.root)

    override fun onClick(v: View) {
        val doctor = doctors.filter {
            it.name == v.tag.toString()
        }[0]

        Navigation.findNavController(v)
            .navigate(DoctorListFragmentDirections.doctorListToDoctorProfile(doctor))
    }

}