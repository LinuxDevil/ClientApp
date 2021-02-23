package com.aligmohammad.doctorapp.ui.fragments.doctormajor;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DoctorMajorFragmentDirections {
  private DoctorMajorFragmentDirections() {
  }

  @NonNull
  public static MajorToDoctorList majorToDoctorList() {
    return new MajorToDoctorList();
  }

  public static class MajorToDoctorList implements NavDirections {
    private final HashMap arguments = new HashMap();

    private MajorToDoctorList() {
    }

    @NonNull
    public MajorToDoctorList setType(@NonNull String type) {
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("type", type);
      return this;
    }

    @NonNull
    public MajorToDoctorList setMajor(@NonNull String major) {
      if (major == null) {
        throw new IllegalArgumentException("Argument \"major\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("major", major);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("type")) {
        String type = (String) arguments.get("type");
        __result.putString("type", type);
      } else {
        __result.putString("type", "doctor");
      }
      if (arguments.containsKey("major")) {
        String major = (String) arguments.get("major");
        __result.putString("major", major);
      } else {
        __result.putString("major", "Specalists");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.majorToDoctorList;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getType() {
      return (String) arguments.get("type");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getMajor() {
      return (String) arguments.get("major");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      MajorToDoctorList that = (MajorToDoctorList) object;
      if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
        return false;
      }
      if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
        return false;
      }
      if (arguments.containsKey("major") != that.arguments.containsKey("major")) {
        return false;
      }
      if (getMajor() != null ? !getMajor().equals(that.getMajor()) : that.getMajor() != null) {
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
      result = 31 * result + (getType() != null ? getType().hashCode() : 0);
      result = 31 * result + (getMajor() != null ? getMajor().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "MajorToDoctorList(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + ", major=" + getMajor()
          + "}";
    }
  }
}
