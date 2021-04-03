package com.aligmohammad.doctorapp.ui.fragments.homefragment

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
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.data.network.responses.MenuItemResponseItem
import com.aligmohammad.doctorapp.databinding.HomeFragmentBinding
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import com.aligmohammad.doctorapp.ui.adapters.HomeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel
import com.aligmohammad.doctorapp.ui.fragments.newappointmentfragment.NewAppointmentFragmentDirections.*
import com.aligmohammad.doctorapp.util.handleApiError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_fragment.view.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment), OnMenuItemClick {

    private val viewModel by viewModels<HomeViewModel>()
    private val authViewModel by viewModels<AuthViewModel>()

    private var menuItems = ArrayList<MenuItemResponseItem>()
    private lateinit var userPreferencesStore: PreferencesStore

    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapter: HomeRecyclerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPreferencesStore = PreferencesStore(requireContext())

        userPreferencesStore.accessToken.asLiveData().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                getCurrentUser(it)
            } else {
                authViewModel.logoutUser()
                redirectToLoginPage()
            }
        })

        binding = HomeFragmentBinding.bind(view)
        initializeUI()
        initializeRecycler()

        initAd()

        viewModel.getMenuItems()

        authViewModel.currentUserResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    UserSingleton.setUser(it.value)
                    Log.v("Current User", "Success ${it.value.name}")
                }
                is Resource.Failure -> {
                    Log.v("Current User", "Failed")
                }
                Resource.Loading -> {
                    Log.v("Current User", "Loading")
                }
            }
        })

        viewModel.menuItemReponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    if (it.value.menuItems.size > 0) {
                        Log.v("Success", it.value.menuItems[0].nameEn)
                        adapter = HomeRecyclerAdapter(it.value.menuItems, this)
                        binding.homeListRecycler.adapter = adapter
                    }
                }
                is Resource.Failure -> handleApiError(it) {
                    Log.v("Failure", it.errorCode!!.toString())
                }
            }
        })


    }

    private fun getCurrentUser(token: String) {
        authViewModel.getCurrentUserDetails(token)
    }

    private fun initAd() {
        MobileAds.initialize(requireContext()) {}
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onClick(v: View) {
        val navController = Navigation.findNavController(v)
        when (v.findViewById<TextView>(R.id.itemName).text.toString()) {
            "New Appointment" -> {
                navController.navigate(HomeFragmentDirections.actionHomeToNewAppointment())
            }
            "Today's Appointments" -> {
                navController.navigate(HomeFragmentDirections.homeToAppointemtnsUser())
            }
            "My Appointments" -> {
                navController.navigate(
                    HomeFragmentDirections.homeToAppointemtnsUser()
                )
            }
            "Cancel Appointments" -> {
                navController.navigate(
                    HomeFragmentDirections.actionHomeToNewAppointment()
                )
            }
            "Add New Sibling" -> {
                navController.navigate(
                    HomeFragmentDirections.homeToAddNewMember()
                )
            }
            else -> {
                navController.navigate(
                    HomeFragmentDirections.actionHomeToNewAppointment()
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
                binding.root.drawerLayout
            )
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        setHasOptionsMenu(true)
        binding.root.navigationView.setupWithNavController(findNavController())
        binding.root.navigationView.setNavigationItemSelectedListener {
            val id = it.itemId
            when (id) {
                R.id.logout -> {
                    authViewModel.logoutUser()
                    redirectToLoginPage()
                }

                R.id.mainProfileFragment -> {
                    findNavController().navigate(HomeFragmentDirections.homeToProfile())
                }

                R.id.offersListFragment -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToOffersListFragment())
                }

                R.id.settingsFragment -> {
                    findNavController().navigate(HomeFragmentDirections.homeToSettings())
                }
                R.id.addNewSibling -> {
                    findNavController().navigate(HomeFragmentDirections.homeToAddNewMember())
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    private fun redirectToLoginPage() {
        findNavController().navigateUp()
    }

}