package com.aligmohammad.doctorapp.ui.fragments.armyplaces

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.response.ArmyPlaceResponseItem
import com.aligmohammad.doctorapp.databinding.ArmyListFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.ArmyPlacesRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.fragments.doctorlist.DoctorListFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.doctor_list_fragment.view.*
import java.util.*

@AndroidEntryPoint
class ArmyListFragment : Fragment() {

    private var selectedCity = ""
    private var selectedDistrict = ""
    private var selectedInsurance = ""

    private var searchText = ""

    private lateinit var placeAdapter: ArmyPlacesRecyclerViewAdapter
    private val viewModel: ArmyListViewModel by viewModels<ArmyListViewModel>()
    private lateinit var binding: ArmyListFragmentBinding

    private var places: List<ArmyPlaceResponseItem> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.army_list_fragment, container, false)
        setUpUI()
        return binding.root
    }

    private fun setUpUI() {
        initRecycler()
        initAppbar()
        setWatchers()
        initData()
    }

    private fun initData() {
        navArgs<DoctorListFragmentArgs>().value.let {
            selectedCity = it.city!!
            selectedDistrict = it.district!!
            selectedInsurance = it.insuranceName!!
        }

        viewModel.getPlaces()
    }

    private fun initRecycler() {

        placeAdapter =
            ArmyPlacesRecyclerViewAdapter(places, "Pharmacy")
        placeAdapter.notifyDataSetChanged()
        binding.root.list.adapter = placeAdapter

        binding.root.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun initAppbar() {
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        binding.root.toolbar.title =
            navArgs<DoctorListFragmentArgs>().value.type.capitalize(Locale.ROOT)[0] + navArgs<DoctorListFragmentArgs>().value.type.substring(
                1,
                navArgs<DoctorListFragmentArgs>().value.type.length
            )
    }

    private fun setWatchers() {
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchText = p0.toString().toLowerCase(Locale.ROOT)
                val filteredDoctors = places.filter { doc ->
                    doc.nameEn.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                }
                placeAdapter = ArmyPlacesRecyclerViewAdapter(filteredDoctors)
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        viewModel.armyResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Loading -> {

                }
                is Resource.Failure -> {

                }
                is Resource.Success -> {
                    places = it.value
                    initRecycler()
                }
            }
        })

    }
}