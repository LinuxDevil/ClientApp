package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.databinding.FragmentPhoneCodeBinding
import com.aligmohammad.doctorapp.util.loadGif
import kotlinx.android.synthetic.main.fragment_phone_code.view.*
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance


class PhoneCodeFragment : Fragment(), DIAware {

    override val di: DI by lazy { (context?.applicationContext as DIAware).di }

    private lateinit var viewModel: AuthViewModel
    private val factory: AuthViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPhoneCodeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_phone_code, container, false)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewModel = viewModel

        binding.root.success.loadGif(R.drawable.sucess, "Loading")

        return binding.root
    }

}