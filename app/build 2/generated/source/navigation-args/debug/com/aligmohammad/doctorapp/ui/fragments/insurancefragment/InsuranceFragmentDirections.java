package com.aligmohammad.doctorapp.ui.fragments.insurancefragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class InsuranceFragmentDirections {
  private InsuranceFragmentDirections() {
  }

  @NonNull
  public static NavDirections insuracneToHome() {
    return new ActionOnlyNavDirections(R.id.insuracneToHome);
  }
}
