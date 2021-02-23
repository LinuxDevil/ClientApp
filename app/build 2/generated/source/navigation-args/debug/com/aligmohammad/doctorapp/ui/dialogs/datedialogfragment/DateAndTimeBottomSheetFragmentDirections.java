package com.aligmohammad.doctorapp.ui.dialogs.datedialogfragment;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class DateAndTimeBottomSheetFragmentDirections {
  private DateAndTimeBottomSheetFragmentDirections() {
  }

  @NonNull
  public static NavDirections backToHome() {
    return new ActionOnlyNavDirections(R.id.backToHome);
  }
}
