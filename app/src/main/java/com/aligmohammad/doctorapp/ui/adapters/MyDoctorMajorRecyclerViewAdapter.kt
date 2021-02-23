package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.firebasemodels.MajorsFirebaseModel
import com.aligmohammad.doctorapp.databinding.DoctorMajorItemBinding


class MyDoctorMajorRecyclerViewAdapter(
    private val values: List<MajorsFirebaseModel>,
    private val onMenuItemClick: OnMenuItemClick
) : RecyclerView.Adapter<MyDoctorMajorRecyclerViewAdapter.ViewHolder>(), OnMenuItemClick {

    private lateinit var binding: DoctorMajorItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.doctor_major_item,
            parent,
            false
        )
        binding.listener = this
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        binding.menuItem = item
    }

    override fun getItemCount(): Int = values.size

    fun getClickedElement() {
    }

    inner class ViewHolder(view: DoctorMajorItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onClick(v: View) {
        this.onMenuItemClick.onClickMenu(v, binding.menuItem!!)
    }
}