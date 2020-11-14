package com.aligmohammad.doctorapp.ui.fragments.homefragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
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
            AppBarConfiguration(setOf(R.id.homeFragment, R.id.governmentHospitalsFragment))
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        setHasOptionsMenu(true)
        binding.root.toolbar.inflateMenu(R.menu.home_menu)
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
        if (v.findViewById<TextView>(R.id.itemName).text.toString() == "Specialists Doctors") {
            Navigation.findNavController(v).navigate(HomeFragmentDirections.homeToDoctorMajor())
        } else if (v.findViewById<TextView>(R.id.itemName).text.toString() == "General Doctors") {
            Navigation.findNavController(v).navigate(HomeFragmentDirections.homeToDoctorList())
        } else {
            Navigation.findNavController(v).navigate(
                HomeFragmentDirections.actionHomeFragmentToBottomSheetGovernment()
                    .setType(v.findViewById<TextView>(R.id.itemName).text.toString())
            )
        }
    }

}