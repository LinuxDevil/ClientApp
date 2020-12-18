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

package com.aligmohammad.doctorapp.ui.fragments.homefragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.HomeFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.HomeRecyclerAdapter
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import kotlinx.android.synthetic.main.home_fragment.view.*
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class HomeFragment : Fragment(), DIAware, OnMenuItemClick {

    override val di: DI by lazy { (context?.applicationContext as DIAware).di }
    private val factory: HomeFragmentViewModelFactory by instance()
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        val appBarConfiguration =
            AppBarConfiguration(
                setOf(R.id.homeFragment, R.id.governmentHospitalsFragment),
                binding.root.drawerLayout
            )
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        setHasOptionsMenu(true)
        binding.root.navigationView.setupWithNavController(findNavController())
        binding.viewModel = viewModel
        initializeRecycler()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    fun initializeRecycler() {
        val adapter = HomeRecyclerAdapter(viewModel.dummyList(), this)
        binding.homeListRecycler.adapter = adapter
    }

    override fun onClick(v: View) {
        val navController = Navigation.findNavController(v)
        when (v.findViewById<TextView>(R.id.itemName).text.toString()) {
            "Specialists Doctors" -> {
                navController.navigate(HomeFragmentDirections.homeToDoctorMajor())
            }
            "General Doctors" -> {
                navController.navigate(HomeFragmentDirections.homeToDoctorList())
            }
            "X-Rays" -> {
                navController.navigate(
                    HomeFragmentDirections.homeToCityDistrictCompany().setType("x-rays")
                )
            }
            "Labs" -> {
                navController.navigate(
                    HomeFragmentDirections.homeToCityDistrictCompany().setType("labs")
                )
            }
            "Pharmacies" -> {
                navController.navigate(
                    HomeFragmentDirections.homeToCityDistrictCompany().setType("pharmacies")
                )
            }
            "Doctor consultation" -> {
                navController.navigate(HomeFragmentDirections.homeToDoctorConsulting())
            }
            "Offers" -> {
                Toast.makeText(context, "There's no offers now", Toast.LENGTH_LONG).show()
            }
            else -> {
                navController.navigate(
                    HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
                        .setType(v.findViewById<TextView>(R.id.itemName).text.toString())
                )
            }
        }
    }

}