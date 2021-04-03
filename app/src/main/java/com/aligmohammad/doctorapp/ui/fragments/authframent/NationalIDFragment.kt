package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.dto.UserDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.FragmentNationalIdBinding
import com.aligmohammad.doctorapp.util.handleApiError
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import dagger.hilt.android.AndroidEntryPoint
import navigateSafe

@AndroidEntryPoint
class NationalIDFragment : Fragment(R.layout.fragment_national_id) {

    private val viewModel by viewModels<NationalIDViewModel>()
    private lateinit var binding: FragmentNationalIdBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = FragmentNationalIdBinding.bind(view)

        Toast.makeText(requireContext(), UserSingleton.getCurrentUser().username, Toast.LENGTH_LONG)
            .show()

        viewModel.userResponse.observe(viewLifecycleOwner, Observer {
            hideKeyboard()
            when (it) {
                is Resource.Success -> {
                    navigateSafe(NationalIDFragmentDirections.phoneToInsurance())
                }
                is Resource.Failure -> handleApiError(it) {
                    binding.emailEditText.snackbar(it.errorCode.toString())
                }
            }
        })

        binding.registerButton.setOnClickListener {
            hideKeyboard()
            // TODO: Validation
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val bio = binding.bioEditText.text.toString()
            val city = binding.cityEditText.text.toString()
            val district = binding.districtEditText.text.toString()
            val nickname = binding.nicknameEditText.text.toString()
            val nationalId = binding.nationalityIdEditText.text.toString()

            val userDto = UserDTO(name, email, bio, "", "", city, district, nickname, nationalId)
            viewModel.updateUser(userDto)
        }

    }

}