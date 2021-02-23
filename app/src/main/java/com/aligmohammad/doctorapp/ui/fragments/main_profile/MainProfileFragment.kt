package com.aligmohammad.doctorapp.ui.fragments.main_profile

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.data.network.response.User
import com.aligmohammad.doctorapp.databinding.MainProfileFragmentBinding
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick
import com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel
import com.aligmohammad.doctorapp.util.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_profile_fragment.view.*
import navigateSafe

@AndroidEntryPoint
class MainProfileFragment : Fragment() {

    private lateinit var viewModel: MainProfileViewModel
    private val authViewModel by viewModels<AuthViewModel>()

    private lateinit var binding: MainProfileFragmentBinding

    private var name: String = ""
    private var insurance: String = ""
    private var insuranceNumber: String = ""
    private var username: String = ""
    private var location: String = ""
    private lateinit var userInfo: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.main_profile_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MainProfileViewModel::class.java)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph, null)
        binding.root.toolbar.setupWithNavController(findNavController(), appBarConfiguration)

        userInfo = UserSingleton.getCurrentUser()
        updateUI(true)

        setHasOptionsMenu(true)

        authViewModel.getCurrentUserDetails("")

        authViewModel.currentUserResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    UserSingleton.setUser(it.value)
                    userInfo = it.value;
                    updateUI(false)
                    Log.v("Current User", "Success ${it.value.name}")
                }
                is Resource.Failure -> {
                    Log.v("Current User", "Failed")
                }
                Resource.Loading -> {
                    Log.v("Current User", "Loading")
                    updateUI(true)
                }
            }
        })

        if (userInfo.name != null) {
            Log.v("User", userInfo.nickname)
            name = userInfo.name!!
            insuranceNumber = userInfo.insuranceNumber!!
            username = userInfo.username!!
            location = userInfo.city!! + ", " + userInfo.district!!
        } else {
            Log.v("User", "Null")

        }

        binding.toolbar.inflateMenu(R.menu.profile_menu)
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.editProfile -> {
                    navigateSafe(MainProfileFragmentDirections.profileToEditProfile().setUser(userInfo))
                    true
                }
                else -> {
                    Toast.makeText(requireContext(), "Something else ", Toast.LENGTH_LONG).show()
                    true
                }
            }
        }
        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.profile_menu, menu)
        return
    }

    private fun updateUI(isLoading: Boolean) {
        if (isLoading) {
            binding.doctorName.setText("Loading")
            binding.doctorMajor.setText("Loading")
            binding.doctorYearsOfExperience.setText("Loading")

            binding.doctorLocation.setText("Loading")
            binding.bioTextView.setText("Loading")
            binding.emailTextView.setText("Loading")
            binding.nicknameTextView.setText("Loading")
        } else {
            binding.doctorImage.loadImage(
                userInfo.image,
                CircularProgressDrawable(requireContext())
            )
            binding.doctorName.setText("Name: " + userInfo.name)
            binding.doctorMajor.setText("Insurance No. : " + userInfo.insuranceNumber)
            binding.doctorYearsOfExperience.setText("Mobile: " + userInfo.username)

            binding.doctorLocation.setText("Location: " + userInfo.city + ", " + userInfo.district)
            binding.bioTextView.setText("Bio: ${userInfo.bio}")
            binding.emailTextView.setText("Email: ${userInfo.email}")
            binding.nicknameTextView.setText("Nickname: ${userInfo.nickname}")
        }
    }


}