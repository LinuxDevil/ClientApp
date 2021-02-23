package com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.symptoms;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class SymptomsBottomSheetFragmentDirections {
  private SymptomsBottomSheetFragmentDirections() {
  }

  @NonNull
  public static NavDirections symptomsToResult() {
    return new ActionOnlyNavDirections(R.id.symptomsToResult);
  }
}
