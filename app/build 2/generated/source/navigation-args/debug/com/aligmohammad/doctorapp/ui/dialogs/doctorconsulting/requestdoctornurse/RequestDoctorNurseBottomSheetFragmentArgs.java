package com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.requestdoctornurse;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class RequestDoctorNurseBottomSheetFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private RequestDoctorNurseBottomSheetFragmentArgs() {
  }

  private RequestDoctorNurseBottomSheetFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static RequestDoctorNurseBottomSheetFragmentArgs fromBundle(@NonNull Bundle bundle) {
    RequestDoctorNurseBottomSheetFragmentArgs __result = new RequestDoctorNurseBottomSheetFragmentArgs();
    bundle.setClassLoader(RequestDoctorNurseBottomSheetFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("type")) {
      String type;
      type = bundle.getString("type");
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("type", type);
    } else {
      throw new IllegalArgumentException("Required argument \"type\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getType() {
    return (String) arguments.get("type");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("type")) {
      String type = (String) arguments.get("type");
      __result.putString("type", type);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    RequestDoctorNurseBottomSheetFragmentArgs that = (RequestDoctorNurseBottomSheetFragmentArgs) object;
    if (arguments.containsKey("type") != that.arguments.containsKey("type")) {
      return false;
    }
    if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getType() != null ? getType().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "RequestDoctorNurseBottomSheetFragmentArgs{"
        + "type=" + getType()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(RequestDoctorNurseBottomSheetFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder(@NonNull String type) {
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("type", type);
    }

    @NonNull
    public RequestDoctorNurseBottomSheetFragmentArgs build() {
      RequestDoctorNurseBottomSheetFragmentArgs result = new RequestDoctorNurseBottomSheetFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setType(@NonNull String type) {
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("type", type);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getType() {
      return (String) arguments.get("type");
    }
  }
}
