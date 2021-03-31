package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.Doctor
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.response.PlaceListResponseItem
import com.aligmohammad.doctorapp.databinding.DoctorListFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DoctorListRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.adapters.PlaceListRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.doctor_list_fragment.view.*
import java.util.*

@AndroidEntryPoint
class DoctorListFragment : Fragment(R.layout.doctor_list_fragment) {

    private val viewModel by viewModels<DoctorListViewModel>()
    private lateinit var binding: DoctorListFragmentBinding

    private lateinit var adapter: DoctorListRecyclerViewAdapter
    private lateinit var placeAdapter: PlaceListRecyclerViewAdapter

    private val doctors = arrayListOf<Doctor>()
    private var places = arrayListOf<PlaceListResponseItem>()

    private var selectedCity = ""
    private var selectedDistrict = ""
    private var selectedInsurance = ""

    private var searchText = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DoctorListFragmentBinding.bind(view)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchText = p0.toString().toLowerCase(Locale.ROOT)
                when (navArgs<DoctorListFragmentArgs>().value.type) {
                    "doctor" -> {
                        val filteredDoctors = doctors.filter { doc ->
                            doc.name!!.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        adapter = DoctorListRecyclerViewAdapter(emptyList())
                        adapter.notifyDataSetChanged()
                        binding.root.list.adapter = adapter
                    }
                    "x-rays" -> {
                        val filteredDoctors = places.filter { doc ->
                            doc.name.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        placeAdapter = PlaceListRecyclerViewAdapter(filteredDoctors)
                        placeAdapter.notifyDataSetChanged()
                        binding.root.list.adapter = placeAdapter
                    }
                    "labs" -> {
                        val filteredDoctors = places.filter { doc ->
                            doc.name.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        placeAdapter = PlaceListRecyclerViewAdapter(filteredDoctors)
                        placeAdapter.notifyDataSetChanged()
                        binding.root.list.adapter = placeAdapter
                    }
                    "pharmacies" -> {
                        val filteredDoctors = places.filter { doc ->
                            doc.name.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        placeAdapter = PlaceListRecyclerViewAdapter(filteredDoctors)
                        placeAdapter.notifyDataSetChanged()
                        binding.root.list.adapter = placeAdapter
                    }
                }

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })



        binding.root.toolbar.title =
            navArgs<DoctorListFragmentArgs>().value.type.capitalize(Locale.ROOT)[0] + navArgs<DoctorListFragmentArgs>().value.type.substring(
                1,
                navArgs<DoctorListFragmentArgs>().value.type.length
            )

        navArgs<DoctorListFragmentArgs>().value.let {
            selectedCity = it.city!!
            selectedDistrict = it.district!!
            selectedInsurance = it.insuranceName!!
        }

        viewModel.doctorListResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Loading -> {
                    Log.v("ViewModel", "Loading")
                }
                is Resource.Success -> {
                    Log.v("ViewModel", "Success ${it.value.doctors.size} size")

                    adapter = DoctorListRecyclerViewAdapter(it.value.doctors)
                    adapter.notifyDataSetChanged()
                    binding.root.list.adapter = adapter

                }
                is Resource.Failure -> {
                    Log.v("ViewModel", "Failure ${it.errorCode}")

                }
            }
        })

        viewModel.placeListResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Loading -> {
                    Log.v("ViewModel", "Loading")
                }
                is Resource.Success -> {
                    Log.v("ViewModel", "Success ${it.value.size} size")

                }
                is Resource.Failure -> {
                    Log.v("ViewModel", "Failure ${it.errorCode}")

                }
            }
        })

        when (navArgs<DoctorListFragmentArgs>().value.type) {
            "doctor" -> {
                viewModel.getDoctorListFilter()
            }
            "x-rays" -> {
                viewModel.getPlaceList("1", "X-Rays")
            }
            "labs" -> {
                viewModel.getPlaceList("1", "Labs")
            }
            "pharmacies" -> {
                viewModel.getPlaceList("1", "Pharmacies")
            }
        }
        initRecycler()
    }

    private fun initRecycler() {

        when (navArgs<DoctorListFragmentArgs>().value.type) {
            "doctor" -> {
                adapter = DoctorListRecyclerViewAdapter(
                    emptyList()
                )
                adapter.notifyDataSetChanged()
                binding.root.list.adapter = adapter
            }
            "x-rays" -> {
                placeAdapter = PlaceListRecyclerViewAdapter(places, "X-Rays")
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter
            }
            "labs" -> {
                placeAdapter = PlaceListRecyclerViewAdapter(places, "Labs")
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter
            }
            "pharmacies" -> {
                placeAdapter =
                    PlaceListRecyclerViewAdapter(places, "Pharmacy")
                placeAdapter.notifyDataSetChanged()
                binding.root.list.adapter = placeAdapter
            }
        }

        binding.root.list.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

}