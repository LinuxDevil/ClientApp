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

package com.aligmohammad.doctorapp.ui.fragments.insurancefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.InsuranceFragmentBinding
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class InsuranceFragment : Fragment(), DIAware {

    override val di: DI by lazy { (context?.applicationContext as DIAware).di }
    private lateinit var viewModel: InsuranceViewModel
    val factory: InsuranceViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InsuranceFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.insurance_fragment, container, false)
        viewModel = ViewModelProvider(this, factory).get(InsuranceViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

}