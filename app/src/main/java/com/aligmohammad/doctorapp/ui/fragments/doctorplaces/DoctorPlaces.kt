package com.aligmohammad.doctorapp.ui.fragments.doctorplaces

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R

class DoctorPlaces : Fragment() {

    companion object {
        fun newInstance() = DoctorPlaces()
    }

    private lateinit var viewModel: DoctorPlacesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.doctor_places_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoctorPlacesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}