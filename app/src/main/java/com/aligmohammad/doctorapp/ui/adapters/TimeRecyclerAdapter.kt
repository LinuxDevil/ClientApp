

package com.aligmohammad.doctorapp.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.DateTime
import com.aligmohammad.doctorapp.databinding.TimeSingleItemBinding

class TimeRecyclerAdapter(private val times: List<String>) :
    RecyclerView.Adapter<TimeRecyclerAdapter.TimeRecyclerViewHolder>() {

    private var isSelected = false
    private var selection: String = ""

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimeRecyclerAdapter.TimeRecyclerViewHolder {
        val binding: TimeSingleItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.time_single_item,
            parent,
            false
        )
        return TimeRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TimeRecyclerAdapter.TimeRecyclerViewHolder,
        position: Int
    ) {
        holder.timeSingleItemBinding.cardView.apply {
            if (isSelected) {
                strokeColor = Color.BLUE
                strokeWidth = 2
            } else {
                strokeWidth = 0
            }
        }
        holder.timeSingleItemBinding.time = times[position]
        holder.timeSingleItemBinding.cardView.setOnClickListener {
            holder.timeSingleItemBinding.cardView.apply {
                resetAll()
                holder.timeSingleItemBinding.cardView.apply {
                    if (!isSelected) {
                        strokeColor = Color.BLUE
                        strokeWidth = 2
                    } else {
                        strokeWidth = 0
                    }
                    selection = times[position]
                    isSelected = !isSelected
                }
            }
        }
    }

    private fun resetAll() {
        times.map { dateTime ->
            isSelected = false
        }
        notifyDataSetChanged()
    }
    public fun getSelection(): String = selection

    override fun getItemCount(): Int = times.size

    inner class TimeRecyclerViewHolder(val timeSingleItemBinding: TimeSingleItemBinding) :
        RecyclerView.ViewHolder(timeSingleItemBinding.root)


}