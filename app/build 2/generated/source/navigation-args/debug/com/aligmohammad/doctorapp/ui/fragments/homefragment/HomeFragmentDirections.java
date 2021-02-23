package com.aligmohammad.doctorapp.ui.fragments.homefragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.aligmohammad.doctorapp.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static ActionHomeFragmentToBottomSheetGovernment actionHomeFragmentToBottomSheetGovernment(
      ) {
    return new ActionHomeFragmentToBottomSheetGovernment();
  }

  @NonNull
  public static NavDirections homeToDoctorMajor() {
    return new ActionOnlyNavDirections(R.id.homeToDoctorMajor);
  }

  @NonNull
  public static HomeToDoctorList homeToDoctorList() {
    return new HomeToDoctorList();
  }

  @NonNull
  public static HomeToXRay homeToXRay() {
    return new HomeToXRay();
  }

  @NonNull
  public static HomeToCityDistrictCompany homeToCityDistrictCompany() {
    return new HomeToCityDistrictCompany();
  }

  @NonNull
  public static NavDirections homeToDoctorConsulting() {
    return new ActionOnlyNavDirections(R.id.homeToDoctorConsulting);
  }

  public static class ActionHomeFragmentToBottomSheetGovernment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionHomeFragmentToBottomSheetGovernment() {
    }

    @NonNull
    public ActionHomeFragmentToBottomSheetGovernment setType(@NonNull String type) {
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
        __result.putString("type", "Government Hospitals");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_bottom_sheet_government;
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
      ActionHomeFragmentToBottomSheetGovernment that = (ActionHomeFragmentToBottomSheetGovernment) object;
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
      return "ActionHomeFragmentToBottomSheetGovernment(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + "}";
    }
  }

  public static class HomeToDoctorList implements NavDirections {
    private final HashMap arguments = new HashMap();

    private HomeToDoctorList() {
    }

    @NonNull
    public HomeToDoctorList setType(@NonNull String type) {
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("type", type);
      return this;
    }

    @NonNull
    public HomeToDoctorList setMajor(@NonNull String major) {
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
      return R.id.homeToDoctorList;
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
      HomeToDoctorList that = (HomeToDoctorList) object;
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
      return "HomeToDoctorList(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + ", major=" + getMajor()
          + "}";
    }
  }

  public static class HomeToXRay implements NavDirections {
    private final HashMap arguments = new HashMap();

    private HomeToXRay() {
    }

    @NonNull
    public HomeToXRay setType(@NonNull String type) {
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
        __result.putString("type", "labs");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.homeToXRay;
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
      HomeToXRay that = (HomeToXRay) object;
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
      return "HomeToXRay(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + "}";
    }
  }

  public static class HomeToCityDistrictCompany implements NavDirections {
    private final HashMap arguments = new HashMap();

    private HomeToCityDistrictCompany() {
    }

    @NonNull
    public HomeToCityDistrictCompany setType(@NonNull String type) {
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
        __result.putString("type", "labs");
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.homeToCityDistrictCompany;
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
      HomeToCityDistrictCompany that = (HomeToCityDistrictCompany) object;
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
      return "HomeToCityDistrictCompany(actionId=" + getActionId() + "){"
          + "type=" + getType()
          + "}";
    }
  }
}
