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

package com.aligmohammad.doctorapp.ui.fragments.main_profile

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
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.MainProfileFragmentBinding
import kotlinx.android.synthetic.main.main_profile_fragment.view.*

class MainProfileFragment : Fragment() {

    private lateinit var viewModel: MainProfileViewModel
    private lateinit var binding: MainProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.main_profile_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MainProfileViewModel::class.java)
        val appBarConfiguration =
            AppBarConfiguration(
                findNavController().graph,
                null
            )
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)
        setHasOptionsMenu(true)
        return binding.root
    }


}