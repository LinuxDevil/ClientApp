package com.aligmohammad.doctorapp.ui.dialogs.governmentchoice;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class GovernmentHospitalChoiceDirections {
  private GovernmentHospitalChoiceDirections() {
  }

  @NonNull
  public static NavDirections govChoiceToGovHospitals() {
    return new ActionOnlyNavDirections(R.id.govChoiceToGovHospitals);
  }

  @NonNull
  public static NavDirections govChoiceToPrivateHospitals() {
    return new ActionOnlyNavDirections(R.id.govChoiceToPrivateHospitals);
  }
}
