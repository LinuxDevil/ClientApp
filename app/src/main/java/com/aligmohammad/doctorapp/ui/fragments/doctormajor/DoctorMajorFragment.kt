package com.aligmohammad.doctorapp.ui.fragments.doctormajor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.RecyclerMenuItem
import com.aligmohammad.doctorapp.ui.adapters.MyDoctorMajorRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.fragments.homefragment.HomeFragmentDirections

class DoctorMajorFragment : Fragment() {

    private var columnCount = 3
    private val arrayList = arrayListOf<RecyclerMenuItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.doctor_major_fragment_item_list, container, false)
        getData();
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyDoctorMajorRecyclerViewAdapter(arrayList)
            }
        }
        return view
    }

    private fun getData() {
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
        arrayList.add(RecyclerMenuItem("New Name", "", HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()))
    }

}