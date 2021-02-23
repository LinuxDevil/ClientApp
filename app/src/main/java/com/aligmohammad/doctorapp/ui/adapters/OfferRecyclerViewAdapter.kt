package com.aligmohammad.doctorapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.firebasemodels.MajorsFirebaseModel
import com.aligmohammad.doctorapp.data.model.firebasemodels.OfferFirebaseModel
import com.aligmohammad.doctorapp.databinding.DoctorMajorItemBinding
import com.aligmohammad.doctorapp.databinding.OfferItemBinding

class OfferRecyclerViewAdapter(
    private val values: List<OfferFirebaseModel>,
    private val onMenuItemClick: OnMenuItemClick
) : RecyclerView.Adapter<OfferRecyclerViewAdapter.ViewHolder>(), OnMenuItemClick {

    private lateinit var binding: OfferItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.offer_item,
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

    inner class ViewHolder(view: OfferItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onClick(v: View) {
        this.onMenuItemClick.onClickMenu(v, binding.menuItem!!)
    }
}