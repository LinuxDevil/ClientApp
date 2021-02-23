package com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting;

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

public class DoctorConsultingBottomSheetFragmentDirections {
  private DoctorConsultingBottomSheetFragmentDirections() {
  }

  @NonNull
  public static DoctorConsultToCityDistrict doctorConsultToCityDistrict() {
    return new DoctorConsultToCityDistrict();
  }

  @NonNull
  public static ConsultToRequestDoctor consultToRequestDoctor() {
    return new ConsultToRequestDoctor();
  }

  public static class DoctorConsultToCityDistrict implements NavDirections {
    private final HashMap arguments = new HashMap();

    private DoctorConsultToCityDistrict() {
    }

    @NonNull
    public DoctorConsultToCityDistrict setType(@NonNull String type) {
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("type", type);
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
        __result.putString("type", "consult");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.doctorConsultToCityDistrict;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getType() {
      return (String) arguments.get("type");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      DoctorConsultToCityDistrict that = (DoctorConsultToCityDistrict) object;
      if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
        return false;
      }
      if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "DoctorConsultToCityDistrict(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + "}";
    }
  }

  public static class ConsultToRequestDoctor implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ConsultToRequestDoctor() {
    }

    @NonNull
    public ConsultToRequestDoctor setType(@NonNull String type) {
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("type", type);
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
        __result.putString("type", "Doctor");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.consultToRequestDoctor;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getType() {
      return (String) arguments.get("type");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ConsultToRequestDoctor that = (ConsultToRequestDoctor) object;
      if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
        return false;
      }
      if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
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
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ConsultToRequestDoctor(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + "}";
    }
  }
}
