package com.aligmohammad.doctorapp.ui.dialogs.privatehospitals;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class PrivateHospitalsFragmentDirections {
  private PrivateHospitalsFragmentDirections() {
  }

  @NonNull
  public static NavDirections privateToExternal() {
    return new ActionOnlyNavDirections(R.id.privateToExternal);
  }

  @NonNull
  public static NavDirections privateToLabs() {
    return new ActionOnlyNavDirections(R.id.privateToLabs);
  }

  @NonNull
  public static NavDirections privateToXRay() {
    return new ActionOnlyNavDirections(R.id.privateToXRay);
  }

  @NonNull
  public static NavDirections privateToNaturalist() {
    return new ActionOnlyNavDirections(R.id.privateToNaturalist);
  }

  @NonNull
  public static NavDirections privateToOperations() {
    return new ActionOnlyNavDirections(R.id.privateToOperations);
  }
}
