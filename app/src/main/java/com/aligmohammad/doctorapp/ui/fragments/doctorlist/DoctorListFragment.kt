package com.aligmohammad.doctorapp.ui.fragments.doctorlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.KeyListener
import android.util.Log
import android.view.KeyEvent
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
import com.aligmohammad.doctorapp.data.model.Place
import com.aligmohammad.doctorapp.databinding.DoctorListFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.DoctorListRecyclerViewAdapter
import com.aligmohammad.doctorapp.ui.adapters.PlaceListRecyclerViewAdapter
import com.aligmohammad.doctorapp.util.snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.doctor_list_fragment.view.*
import java.util.*

class DoctorListFragment : Fragment() {

    private lateinit var viewModel: DoctorListViewModel
    private lateinit var binding: DoctorListFragmentBinding

    private lateinit var adapter: DoctorListRecyclerViewAdapter
    private lateinit var placeAdapter: PlaceListRecyclerViewAdapter

    private val doctors = arrayListOf<Doctor>()
    private var places = arrayListOf<Place>()

    private var selectedCity = ""
    private var selectedDistrict = ""
    private var selectedInsurance = ""

    private var searchText = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.doctor_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(DoctorListViewModel::class.java)

        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        binding.searchBar.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchText = p0.toString().toLowerCase(Locale.ROOT)
                when (navArgs<DoctorListFragmentArgs>().value.type) {
                    "doctor" -> {
                        val filteredDoctors = doctors.filter { doc ->
                            doc.name!!.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        adapter = DoctorListRecyclerViewAdapter(filteredDoctors)
                        adapter.notifyDataSetChanged()
                        binding.root.list.adapter = adapter
                    }
                    "x-rays" -> {
                        val filteredDoctors = places.filter { doc ->
                            doc.name!!.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        placeAdapter = PlaceListRecyclerViewAdapter(filteredDoctors)
                        placeAdapter.notifyDataSetChanged()
                        binding.root.list.adapter = placeAdapter
                    }
                    "labs" -> {
                        val filteredDoctors = places.filter { doc ->
                            doc.name!!.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
                        }
                        placeAdapter = PlaceListRecyclerViewAdapter(filteredDoctors)
                        placeAdapter.notifyDataSetChanged()
                        binding.root.list.adapter = placeAdapter
                    }
                    "pharmacies" -> {
                        val filteredDoctors = places.filter { doc ->
                            doc.name!!.toLowerCase(Locale.ROOT).indexOf(searchText) > -1
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

        when (navArgs<DoctorListFragmentArgs>().value.type) {
            "doctor" -> {
                if (navArgs<DoctorListFragmentArgs>().value.doctorArray != null && navArgs<DoctorListFragmentArgs>().value.doctorArray!!.isNotEmpty()) {
                    getFirebaseDoctorList(navArgs<DoctorListFragmentArgs>().value.doctorArray!!)
                } else {
                    getAllDoctors()
                }
            }
            "x-rays" -> {
                getAllXRays()
            }
            "labs" -> {
                getAllLabs()
            }
            "pharmacies" -> {
                getAllPharmacies()
            }
        }
        initRecycler()
        return binding.root
    }

    private fun getAllPharmacies() {
        val db = Firebase.database.reference
        db.child("Places/Pharmacy").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                places.clear()
                snapshot.children.forEach { snap ->
                    val place: Place = snap.getValue(Place::class.java)!!
                    if (selectedCity.isNotEmpty() && selectedDistrict.isNotEmpty() && selectedInsurance.isNotEmpty()) {
                        if (place.city!!.indexOf(selectedCity) != -1) {
                            if (place.district!!.indexOf(selectedDistrict) != -1) {

                                places.add(place)
                            }
                        }
                    }
                }
                initRecycler()
            }

            override fun onCancelled(error: DatabaseError) {
                binding.searchBar.snackbar(error.message)
            }
        })
    }

    private fun getAllLabs() {
        val db = Firebase.database.reference
        db.child("Places/Labs").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                places.clear()
                snapshot.children.forEach { snap ->
                    val place: Place = snap.getValue(Place::class.java)!!
                    if (selectedCity.isNotEmpty() && selectedDistrict.isNotEmpty() && selectedInsurance.isNotEmpty()) {
                        if (place.city!!.indexOf(selectedCity) != -1) {
                            if (place.district!!.indexOf(selectedDistrict) != -1) {

                                places.add(place)
                            }
                        }
                    }
                }
                initRecycler()
            }

            override fun onCancelled(error: DatabaseError) {
                binding.searchBar.snackbar(error.message)
            }
        })
    }

    private fun getAllDoctors() {
        val db = Firebase.database.reference
        db.child("Doctors").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                doctors.clear()
                snapshot.children.forEach { snap ->
                    val doctor: Doctor = snap.getValue(Doctor::class.java)!!
                    doctors.add(doctor)
                }
                initRecycler()
            }

            override fun onCancelled(error: DatabaseError) {
                binding.searchBar.snackbar(error.message)
            }
        })

    }

    private fun getAllXRays() {
        val db = Firebase.database.reference
        db.child("Places/X-Rays").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                places.clear()
                snapshot.children.forEach { snap ->
                    val place: Place = snap.getValue(Place::class.java)!!
                    if (selectedCity.isNotEmpty() && selectedDistrict.isNotEmpty() && selectedInsurance.isNotEmpty()) {
                        if (place.city!!.indexOf(selectedCity) != -1) {
                            if (place.district!!.indexOf(selectedDistrict) != -1) {
                                if (place.insuranceCompany!!.indexOf(selectedInsurance) != -1) {
                                    places.add(place)
                                }
                            }
                        }
                    }
                }
                initRecycler()
            }

            override fun onCancelled(error: DatabaseError) {
                binding.searchBar.snackbar(error.message)
            }
        })
    }

    private fun getFirebaseDoctorList(doctorArray: Array<String>) {
        val db = Firebase.database.reference
        db.child("Doctors").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                doctors.clear()
                snapshot.children.forEach { snap ->
                    val doctor: Doctor = snap.getValue(Doctor::class.java)!!
                    if (doctorArray.indexOf(doctor.uuid) != -1)
                        doctors.add(doctor)
                }
                initRecycler()
            }

            override fun onCancelled(error: DatabaseError) {
                binding.searchBar.snackbar(error.message)
            }
        })
    }

    private fun initRecycler() {

        when (navArgs<DoctorListFragmentArgs>().value.type) {
            "doctor" -> {
                adapter = DoctorListRecyclerViewAdapter(doctors)
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