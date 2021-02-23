package com.aligmohammad.doctorapp.ui.dialogs.govermenthospitals;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class GovernmentHospitalsFragmentDirections {
  private GovernmentHospitalsFragmentDirections() {
  }

  @NonNull
  public static NavDirections governmentToExternal() {
    return new ActionOnlyNavDirections(R.id.governmentToExternal);
  }

  @NonNull
  public static NavDirections governmentToLabs() {
    return new ActionOnlyNavDirections(R.id.governmentToLabs);
  }

  @NonNull
  public static NavDirections governmentToXRay() {
    return new ActionOnlyNavDirections(R.id.governmentToXRay);
  }

  @NonNull
  public static NavDirections governmentToNaturalist() {
    return new ActionOnlyNavDirections(R.id.governmentToNaturalist);
  }
}
