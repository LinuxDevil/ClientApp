package com.aligmohammad.doctorapp.ui.dialogs.externalchoice;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class ExternalLabBottomSheetFragmentDirections {
  private ExternalLabBottomSheetFragmentDirections() {
  }

  @NonNull
  public static NavDirections externalToDate() {
    return new ActionOnlyNavDirections(R.id.externalToDate);
  }
}
