package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.responses.ArmyPlaceResponseItem
import com.aligmohammad.doctorapp.databinding.ArmyplaceListItemBinding
import com.aligmohammad.doctorapp.ui.fragments.armyplaces.ArmyListFragmentDirections

class ArmyPlacesRecyclerViewAdapter(
    private val places: List<ArmyPlaceResponseItem>,
    private val type: String = "Labs"
) : RecyclerView.Adapter<ArmyPlacesRecyclerViewAdapter.ArmyPlacesViewHolder>(), OnMenuItemClick {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmyPlacesViewHolder {

        val binding: ArmyplaceListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.armyplace_list_item,
            parent,
            false
        )
        binding.listener = this
        return ArmyPlacesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArmyPlacesViewHolder, position: Int) {
        holder.labListItemBinding.data = places[position]
    }

    override fun getItemCount(): Int = places.size

    inner class ArmyPlacesViewHolder(val labListItemBinding: ArmyplaceListItemBinding) :
        RecyclerView.ViewHolder(labListItemBinding.root)

    override fun onClick(v: View) {
        val lab = places.filter {
            it.nameEn == v.tag.toString()
        }[0]

        if (type == "Pharmacy") {
            Navigation.findNavController(v)
                .navigate(
                    ArmyListFragmentDirections.doctorToAppointment("").setDates(
                        lab.appointmentDates.toTypedArray()
                    ).setTimes(lab.appointmentDurations.toTypedArray())
                        .setDoctorShifts(arrayOf("After noon", "Morning"))
                )
        } else {
            Navigation.findNavController(v).navigate(
                ArmyListFragmentDirections.listToLabs().setType(type).setDates(
                    lab.appointmentDates.toTypedArray()
                ).setTimes(lab.appointmentTimes.toTypedArray()).setPlaceUuid("lab.location.nameEn")
            )
        }
    }

}