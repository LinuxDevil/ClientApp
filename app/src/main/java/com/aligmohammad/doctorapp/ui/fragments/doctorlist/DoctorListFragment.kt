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

package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Doctor
import com.aligmohammad.doctorapp.databinding.DoctorListFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DoctorListRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.adapters.PlaceListRecyclerViewAdapter
import kotlinx.android.synthetic.main.doctor_list_fragment.view.*
import java.util.*

class DoctorListFragment : Fragment() {

    private lateinit var viewModel: DoctorListViewModel
    private lateinit var binding: DoctorListFragmentBinding
    private var doctorList: List<Doctor> = listOf()
    private lateinit var adapter: DoctorListRecyclerViewAdapter
    private lateinit var placeAdapter: PlaceListRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.doctor_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DoctorListViewModel::class.java)

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        binding.root.toolbar.title =
            navArgs<DoctorListFragmentArgs>().value.type.capitalize(Locale.ROOT)[0] + navArgs<DoctorListFragmentArgs>().value.type.substring(
                1,
                navArgs<DoctorListFragmentArgs>().value.type.length
            )

        initRecycler()

        return binding.root
    }

    private fun initRecycler() {

        when (navArgs<DoctorListFragmentArgs>().value.type) {
            "doctor" -> {
                adapter = DoctorListRecyclerViewAdapter(viewModel.getDoctorList())
                adapter.notifyDataSetChanged()
                binding.root.list.adapter = adapter
            }
            "x-rays" -> {
                placeAdapter = PlaceListRecyclerViewAdapter(viewModel.getXRays())
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter
            }
            "labs" -> {
                placeAdapter = PlaceListRecyclerViewAdapter(viewModel.getLabs())
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter
            }
            "pharmacies" -> {
                placeAdapter =
                    PlaceListRecyclerViewAdapter(viewModel.getXPharmacies(), "pharmacies")
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter
            }
        }

        binding.root.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

}