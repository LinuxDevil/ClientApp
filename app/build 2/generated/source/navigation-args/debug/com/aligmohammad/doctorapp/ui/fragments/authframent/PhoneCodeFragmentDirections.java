package com.aligmohammad.doctorapp.ui.fragments.authframent;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class PhoneCodeFragmentDirections {
  private PhoneCodeFragmentDirections() {
  }

  @NonNull
  public static NavDirections phoneToInsurance() {
    return new ActionOnlyNavDirections(R.id.phoneToInsurance);
  }
}
