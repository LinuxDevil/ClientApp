package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Doctor
import com.aligmohammad.doctorapp.databinding.DoctorListFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DoctorListRecyclerViewAdapter
import kotlinx.android.synthetic.main.doctor_list_fragment.view.*

class DoctorListFragment : Fragment() {

    private lateinit var viewModel: DoctorListViewModel
    private lateinit var binding: DoctorListFragmentBinding
    private var doctorList: List<Doctor> = listOf()
    private lateinit var adapter: DoctorListRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.doctor_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DoctorListViewModel::class.java)

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        initRecycler()
        return binding.root
    }

    private fun observeData() {
        adapter = DoctorListRecyclerViewAdapter(viewModel.getDoctorList())
        adapter.notifyDataSetChanged()
    }

    private fun initRecycler() {
        adapter = DoctorListRecyclerViewAdapter(viewModel.getDoctorList())
        binding.root.list.adapter = adapter
        binding.root.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

}