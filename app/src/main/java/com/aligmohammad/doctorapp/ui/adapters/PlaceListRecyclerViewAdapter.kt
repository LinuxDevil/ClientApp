/**
 * Copyright Recticode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 *
 * Created by Ali Mohammad
 ******************************************************************************/

package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.responses.Place
import com.aligmohammad.doctorapp.databinding.LabListItemBinding
import com.aligmohammad.doctorapp.ui.fragments.doctorlist.DoctorListFragmentDirections

class PlaceListRecyclerViewAdapter(
    private val places: List<Place>,
    private val type: String = "Labs"
) : RecyclerView.Adapter<PlaceListRecyclerViewAdapter.PlaceListViewHolder>(), OnMenuItemClick {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceListViewHolder {

        val binding: LabListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.lab_list_item,
            parent,
            false
        )
        binding.listener = this
        return PlaceListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaceListViewHolder, position: Int) {
        holder.labListItemBinding.data = places[position]
    }

    override fun getItemCount(): Int = places.size

    inner class PlaceListViewHolder(val labListItemBinding: LabListItemBinding) :
        RecyclerView.ViewHolder(labListItemBinding.root)

    override fun onClick(v: View) {
        val lab = places.filter {
            it.nameEn == v.tag.toString()
        }[0]

        Navigation.findNavController(v)
            .navigate(
                DoctorListFragmentDirections.listToPharmacies()
            )

    }

}