package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.responses.DoctorPlace
import com.aligmohammad.doctorapp.databinding.DoctorplaceListItemBinding
import com.aligmohammad.doctorapp.ui.fragments.doctorplaces.DoctorPlacesDirections

class DoctorPlaceRecyclerViewAdapter(
    private val places: List<DoctorPlace>,
    private val type: String = "Labs"
) : RecyclerView.Adapter<DoctorPlaceRecyclerViewAdapter.DoctorPlaceListViewHolder>(),
    OnMenuItemClick {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorPlaceListViewHolder {

        val binding: DoctorplaceListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.doctorplace_list_item,
            parent,
            false
        )
        binding.listener = this
        return DoctorPlaceListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorPlaceListViewHolder, position: Int) {
        holder.labListItemBinding.data = places[position]
    }

    override fun getItemCount(): Int = places.size

    inner class DoctorPlaceListViewHolder(val labListItemBinding: DoctorplaceListItemBinding) :
        RecyclerView.ViewHolder(labListItemBinding.root)

    override fun onClick(v: View) {
        val lab = places.filter {
            it.nameEn == v.tag.toString()
        }[0]

        if (type == "Pharmacy") {
            Navigation.findNavController(v)
                .navigate(
                    DoctorPlacesDirections.doctorToAppointment("").setDates(
                        lab.appointmentDates.toTypedArray()
                    ).setTimes(lab.appointmentDurations.toTypedArray())
                        .setDoctorShifts(arrayOf("After noon", "Morning"))
                )
        } else {
            Navigation.findNavController(v).navigate(
                DoctorPlacesDirections.listToLabs().setType(type).setDates(
                    lab.appointmentDates.toTypedArray()
                ).setTimes(lab.appointmentTimes.toTypedArray()).setPlaceUuid("lab.location.nameEn")
            )
        }
    }

}