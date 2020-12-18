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

package com.aligmohammad.doctorapp.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.DateTime
import com.aligmohammad.doctorapp.databinding.TimeSingleItemBinding

class TimeRecyclerAdapter(private val times: List<DateTime>) :
    RecyclerView.Adapter<TimeRecyclerAdapter.TimeRecyclerViewHolder>() {

    private var isActive = false

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
            if (times[position].selected) {
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
                    if (!times[position].selected) {
                        strokeColor = Color.BLUE
                        strokeWidth = 2
                    } else {
                        strokeWidth = 0
                    }
                    times[position].selected = !times[position].selected
                }
            }
        }
    }

    private fun resetAll() {
        times.map { dateTime ->
            dateTime.selected = false
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = times.size

    inner class TimeRecyclerViewHolder(val timeSingleItemBinding: TimeSingleItemBinding) :
        RecyclerView.ViewHolder(timeSingleItemBinding.root)


}