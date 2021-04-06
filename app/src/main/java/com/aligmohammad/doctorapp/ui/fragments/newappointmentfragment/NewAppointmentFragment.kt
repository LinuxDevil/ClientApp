package com.aligmohammad.doctorapp.ui.fragments.newappointmentfragment

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.responses.MenuItemResponseItem
import com.aligmohammad.doctorapp.databinding.FragmentNewAppointmentBinding
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import com.aligmohammad.doctorapp.ui.adapters.HomeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel
import com.aligmohammad.doctorapp.ui.fragments.homefragment.HomeViewModel
import com.aligmohammad.doctorapp.util.getUser
import com.aligmohammad.doctorapp.util.handleApiError
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_fragment.view.*

@AndroidEntryPoint
class NewAppointmentFragment : Fragment(R.layout.fragment_new_appointment), OnMenuItemClick {

    private val viewModel by viewModels<HomeViewModel>()
    private val authViewModel by viewModels<AuthViewModel>()
    private var menuItems = ArrayList<MenuItemResponseItem>()
    private lateinit var userPreferencesStore: PreferencesStore

    private lateinit var binding: FragmentNewAppointmentBinding
    private lateinit var adapter: HomeRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPreferencesStore = PreferencesStore(requireContext())

        userPreferencesStore.accessToken.asLiveData().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                getUser(it)
            } else {
                authViewModel.logoutUser()
                redirectToLoginPage()
            }
        })

        binding = FragmentNewAppointmentBinding.bind(view)

        initializeUI()
        initializeRecycler()

        viewModel.getSubMenuItems()

        viewModel.subMenuItemResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    Log.v("Success", it.value.menuItems[0].nameEn)
                    adapter = HomeRecyclerAdapter(it.value.menuItems, this)
                    binding.homeListRecycler.adapter = adapter
                }
                is Resource.Failure -> handleApiError(it) {
                    Log.v("Failure", it.errorCode!!.toString())
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onClick(v: View) {
        val navController = Navigation.findNavController(v)
        when (v.findViewById<TextView>(R.id.itemName).text.toString()) {
            "Specialized doctors" -> {
                navController.navigate(NewAppointmentFragmentDirections.homeToDoctorMajor())
            }
            "General doctors" -> {
                navController.navigate(NewAppointmentFragmentDirections.homeToDoctorList(""))
            }
            "X-Rays" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.homeToCityDistrictCompany().setType("x-rays")
                )
            }
            "Labs" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.homeToCityDistrictCompany().setType("labs")
                )
            }
            "Pharmacies" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.homeToCityDistrictCompany()
                        .setType("pharmacies")
                )
            }
            "Doctor Consultations" -> {
                navController.navigate(NewAppointmentFragmentDirections.homeToDoctorConsulting())
            }
            "Army Places" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.homeToArmyPlacesList("").setType("Army Places")
                )
            }
            "General hospitals" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.actionHomeFragmentToBottomSheetGovernment(null)
                        .setType("General hospitals")
                )
            }
            "Private hospitals" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.actionHomeFragmentToBottomSheetGovernment(null)
                        .setType(v.findViewById<TextView>(R.id.itemName).text.toString())
                )
            }
            "Doctor Places" -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.homeToDoctorPlacesList("")
                        .setType("Doctor Places")
                )
            }
            else -> {
                navController.navigate(
                    NewAppointmentFragmentDirections.actionHomeFragmentToBottomSheetGovernment(null)
                        .setType(v.findViewById<TextView>(R.id.itemName).text.toString())
                )
            }
        }
    }

    private fun initializeRecycler() {
        adapter = HomeRecyclerAdapter(menuItems, this)
        binding.homeListRecycler.adapter = adapter
    }

    private fun initializeUI() {
        val appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.homeFragment, R.id.governmentHospitalsFragment),
                null
            )
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
    }

    private fun redirectToLoginPage() {
        findNavController().navigateUp()
    }

}