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

package com.aligmohammad.doctorapp.ui.fragments.doctormajor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.RecyclerMenuItem
import com.aligmohammad.doctorapp.databinding.DoctorMajorFragmentItemListBinding
import com.aligmohammad.doctorapp.ui.adapters.MyDoctorMajorRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.homefragment.HomeFragmentDirections
import kotlinx.android.synthetic.main.doctor_major_fragment_item_list.view.*

class DoctorMajorFragment : Fragment(), OnMenuItemClick {

    private val arrayList = arrayListOf<RecyclerMenuItem>()

    private var columnCount = 3
    private lateinit var binding: DoctorMajorFragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.doctor_major_fragment_item_list,
            container,
            false
        )
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        getData()
        initRecycler()
        return binding.root
    }

    /**
     * Init recycler view with column count
     */
    private fun initRecycler() {
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyDoctorMajorRecyclerViewAdapter(arrayList, this@DoctorMajorFragment)
        }
    }

    private fun getData() {
        arrayList.clear()
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
        arrayList.add(
            RecyclerMenuItem(
                "New Name",
                "https://images.pexels.com/photos/3825586/pexels-photo-3825586.jpeg",
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
            )
        )
    }

    override fun onClick(v: View) {
        Navigation.findNavController(v).navigate(DoctorMajorFragmentDirections.majorToDoctorList())
    }

}