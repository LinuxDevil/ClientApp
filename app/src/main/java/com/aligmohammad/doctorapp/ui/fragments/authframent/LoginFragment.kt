package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.databinding.FragmentLoginBinding
import com.aligmohammad.doctorapp.helpers.PreferencesStore
import com.aligmohammad.doctorapp.util.hideKeyboard
import com.aligmohammad.doctorapp.util.snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import navigateSafe

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<AuthViewModel>()

    private lateinit var databaseReference: DatabaseReference

    var phoneNumberString: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkToken()
        binding = FragmentLoginBinding.bind(view)

        databaseReference = Firebase.database.reference

        viewModel.verifyResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    if (it.value != null) {
                        if (it.value.status == 1) {
                            hideKeyboard()
                            goToHomePage()
                        } else if (it.value.status == 0) {
                            hideKeyboard()
                            binding.phoneEditText.snackbar("Wrong Code")
                        }
                    }
                }
                is Resource.Failure -> {
                    hideKeyboard()
                    binding.phoneEditText.snackbar("Wrong Code")

                }
            }
        })

        viewModel.authResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    viewModel.saveAccessTokens(it.value.user.token!!, it.value.user.token)
                    UserSingleton.setUser(it.value.user)
                    initializeVerify()
                }
                is Resource.Failure -> {
                    Log.v("Failure", it.errorCode.toString())
                    if (it.errorCode.toString() == "409") {
                        viewModel.login("+962" + binding.phoneEditText.text.toString())
                    }
                }
                else -> {
                    Log.v("Else", "No Idea")
                }
            }
        })

        binding.registerButton.setOnClickListener {
            hideKeyboard()
            if (binding.registerButton.tag == "confirm") {
                confirmCode()
            } else {
                if (binding.phoneEditText.text.toString()
                        .matches("^(77|7|79|78)([0-9]{7})\$".toRegex())
                ) {
                    registerUser()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please enter a valid mobile number and add (+962)",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
    }

    private fun initializeVerify() {
        this.binding.registerButton.tag = "confirm"
        this.binding.registerButton.text = "Confirm"
        this.binding.phoneTextView.text = "Verification code"
        this.binding.phoneEditText.setText("")
    }

    private fun checkToken() {
        val userPreferencesStore = PreferencesStore(requireContext())
        userPreferencesStore.accessToken.asLiveData().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                navigateSafe(LoginFragmentDirections.loginToHome())
            }
        })
    }


    private fun goToHomePage() {
        navigateSafe(LoginFragmentDirections.loginToPhoneAction())
    }

    private fun confirmCode() {
        viewModel.verify(phoneNumberString, binding.phoneEditText.text.toString())
    }

    private fun registerUser() {
        val phoneNumber = "+962" + binding.phoneEditText.text.toString()
        this.phoneNumberString = phoneNumber
        viewModel.register(phoneNumber)
    }

}