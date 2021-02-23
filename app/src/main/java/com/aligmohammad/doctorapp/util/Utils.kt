package com.aligmohammad.doctorapp.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.aligmohammad.doctorapp.data.network.Resource
import com.aligmohammad.doctorapp.data.network.UserSingleton
import com.aligmohammad.doctorapp.data.network.responses.FirebaseUserResponse
import com.aligmohammad.doctorapp.ui.activities.main_activity.MainActivity
import com.aligmohammad.doctorapp.ui.fragments.authframent.LoginFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

fun <A : Activity> Activity.startNewActivity(activity: Class<A>) {
    Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
}
fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Fragment.getUser(phoneNumberString: String) {

}


fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}


fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean) {
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
}

fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}

//TODO: Fix
fun Fragment.logout() = lifecycleScope.launch {
//    if (activity is MainActivity) {
//        (activity as MainActivity).performLogout()
//    }
}

fun Fragment.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetwork!! -> requireView().snackbar(
            "Please check your internet connection",
            retry
        )
        failure.errorCode == 400 -> {
            if (this is LoginFragment) {
                requireView().snackbar("You've entered incorrect email or password")
            } else {
                logout()
            }
        }
        else -> {
            val error = failure.errorResponse?.string().toString()
            requireView().snackbar(error)
        }
    }
}

