package com.aligmohammad.doctorapp.ui.fragments.doctorconsultingresult;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;

public class DoctorConsultResultFragmentDirections {
  private DoctorConsultResultFragmentDirections() {
  }

  @NonNull
  public static NavDirections medicineToOrder() {
    return new ActionOnlyNavDirections(R.id.medicineToOrder);
  }
}
