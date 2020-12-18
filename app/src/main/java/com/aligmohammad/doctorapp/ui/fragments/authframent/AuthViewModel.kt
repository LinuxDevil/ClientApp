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

package com.aligmohammad.doctorapp.ui.fragments.authframent

import android.app.Application
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.Navigation
import com.aligmohammad.doctorapp.BaseViewModel
import com.aligmohammad.doctorapp.R
import com.aligmohammad.doctorapp.data.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository, application: Application) :
    BaseViewModel(application) {

    var username: String = ""
    var phoneNumber: String = ""
    var phoneCode: String = ""
    var sentCode: String = ""

    fun onRegisterClicked(view: View) {
//        Toast.makeText(view.context, view.parent.javaClass.toString(), Toast.LENGTH_LONG).show()
        if ((view.parent as MotionLayout).progress == 0.0f) {
            (view.parent as MotionLayout).transitionToEnd()
        }
        launch {
            delay(2000L)
            repository.registerUser(username, phoneNumber)
            val navController = Navigation.findNavController(view)
            if (navController.currentDestination?.id == R.id.loginFragment) {
                navController.navigate(LoginFragmentDirections.loginToPhoneAction())
            }
        }
    }

    fun onConfirmClicked(view: View) {
        if ((view.parent as MotionLayout).progress == 0.0f) {
            (view.parent as MotionLayout).transitionToEnd()
        }
        launch {
            delay(4000L)
            Navigation.findNavController(view)
                .navigate(PhoneCodeFragmentDirections.phoneToInsurance())
        }
    }


}