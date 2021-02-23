package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.model.UserDTO
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.FragmentEditProfileBinding
import com.aligmohammad.doctorapp.util.handleApiError
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_profile_fragment.view.*
import navigateSafe

@AndroidEntryPoint
class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    private val viewModel by viewModels<NationalIDViewModel>()
    private lateinit var binding: FragmentEditProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = FragmentEditProfileBinding.bind(view)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph, null)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        viewModel.userResponse.observe(viewLifecycleOwner, Observer {
            hideKeyboard()
            when (it) {
                is Resource.Success -> {
                    navigateSafe(EditProfileFragmentDirections.editToHome())
                }
                is Resource.Failure -> handleApiError(it) {
                    binding.emailEditText.snackbar(it.errorCode.toString())
                }
            }
        })

        fillUI()

        binding.registerButton.setOnClickListener {
            hideKeyboard()
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

    private fun fillUI() {
        navArgs<EditProfileFragmentArgs>().value.user?.let {
            binding.nameEditText.setText(it.name)
            binding.emailEditText.setText(it.email)
            binding.bioEditText.setText(it.bio)
            binding.cityEditText.setText(it.city)
            binding.districtEditText.setText(it.district)
            binding.nicknameEditText.setText(it.nickname)
            binding.nationalityIdEditText.setText(it.nationalityId)
        }
    }

}