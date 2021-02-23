package com.aligmohammad.doctorapp.ui.fragments.doctorlist;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.data.model.Doctor;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DoctorListFragmentDirections {
  private DoctorListFragmentDirections() {
  }

  @NonNull
  public static DoctorListToDoctorProfile doctorListToDoctorProfile(@NonNull Doctor doctor) {
    return new DoctorListToDoctorProfile(doctor);
  }

  @NonNull
  public static NavDirections listToLabs() {
    return new ActionOnlyNavDirections(R.id.listToLabs);
  }

  @NonNull
  public static NavDirections listToPharmacies() {
    return new ActionOnlyNavDirections(R.id.listToPharmacies);
  }

  public static class DoctorListToDoctorProfile implements NavDirections {
    private final HashMap arguments = new HashMap();

    private DoctorListToDoctorProfile(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
    }

    @NonNull
    public DoctorListToDoctorProfile setDoctor(@NonNull Doctor doctor) {
      if (doctor == null) {
        throw new IllegalArgumentException("Argument \"doctor\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("doctor", doctor);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("doctor")) {
        Doctor doctor = (Doctor) arguments.get("doctor");
        if (Parcelable.class.isAssignableFrom(Doctor.class) || doctor == null) {
          __result.putParcelable("doctor", Parcelable.class.cast(doctor));
        } else if (Serializable.class.isAssignableFrom(Doctor.class)) {
          __result.putSerializable("doctor", Serializable.class.cast(doctor));
        } else {
          throw new UnsupportedOperationException(Doctor.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.doctorListToDoctorProfile;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Doctor getDoctor() {
      return (Doctor) arguments.get("doctor");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      DoctorListToDoctorProfile that = (DoctorListToDoctorProfile) object;
      if (arguments.containsKey("doctor") != that.arguments.containsKey("doctor")) {
        return false;
      }
      if (getDoctor() != null ? !getDoctor().equals(that.getDoctor()) : that.getDoctor() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getDoctor() != null ? getDoctor().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "DoctorListToDoctorProfile(actionId=" + getActionId() + "){"
          + "doctor=" + getDoctor()
          + "}";
    }
  }
}
