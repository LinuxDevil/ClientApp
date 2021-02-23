

package com.aligmohammad.doctorapp.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.DateTime
import com.aligmohammad.doctorapp.databinding.DateSingleItemBinding

class DateRecyclerAdapter(private val dates: List<String>) :
    RecyclerView.Adapter<DateRecyclerAdapter.DateRecyclerViewHolder>() {

    private var selection: String = ""
    private var isSelected = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateRecyclerViewHolder {
        val binding: DateSingleItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.date_single_item,
            parent,
            false
        )
        return DateRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateRecyclerViewHolder, position: Int) {
        holder.dateItemBinding.cardView.apply {
            if (isSelected) {
                strokeColor = Color.BLUE
                strokeWidth = 2
            } else {
                strokeWidth = 0
            }
        }
        holder.dateItemBinding.date = dates[position]
        holder.dateItemBinding.cardView.setOnClickListener {
            resetAll()
            holder.dateItemBinding.cardView.apply {
                if (!isSelected) {
                    strokeColor = Color.BLUE
                    strokeWidth = 2
                } else {
                    strokeWidth = 0
                }
                selection = dates[position]
                isSelected = !isSelected
            }
        }
    }

    private fun resetAll() {
        dates.map { dateTime ->
            isSelected = false
        }
        notifyDataSetChanged()
    }

    public fun getSelection(): String = selection

    override fun getItemCount(): Int = dates.size

    inner class DateRecyclerViewHolder(val dateItemBinding: DateSingleItemBinding) :
        RecyclerView.ViewHolder(dateItemBinding.root)

}