package com.aligmohammad.doctorapp.ui.fragments.authframent;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections loginToPhoneAction() {
    return new ActionOnlyNavDirections(R.id.loginToPhoneAction);
  }
}
