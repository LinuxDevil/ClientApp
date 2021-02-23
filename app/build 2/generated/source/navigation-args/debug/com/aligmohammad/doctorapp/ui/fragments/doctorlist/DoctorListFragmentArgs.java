package com.aligmohammad.doctorapp.ui.fragments.doctorlist;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class DoctorListFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private DoctorListFragmentArgs() {
  }

  private DoctorListFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static DoctorListFragmentArgs fromBundle(@NonNull Bundle bundle) {
    DoctorListFragmentArgs __result = new DoctorListFragmentArgs();
    bundle.setClassLoader(DoctorListFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("major")) {
      String major;
      major = bundle.getString("major");
      if (major == null) {
        throw new IllegalArgumentException("Argument \"major\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("major", major);
    } else {
      __result.arguments.put("major", "Specalists");
    }
    if (bundle.containsKey("type")) {
      String type;
      type = bundle.getString("type");
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("type", type);
    } else {
      __result.arguments.put("type", "doctor");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getMajor() {
    return (String) arguments.get("major");
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
    if (arguments.containsKey("major")) {
      String major = (String) arguments.get("major");
      __result.putString("major", major);
    } else {
      __result.putString("major", "Specalists");
    }
    if (arguments.containsKey("type")) {
      String type = (String) arguments.get("type");
      __result.putString("type", type);
    } else {
      __result.putString("type", "doctor");
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
    DoctorListFragmentArgs that = (DoctorListFragmentArgs) object;
    if (arguments.containsKey("major") != that.arguments.containsKey("major")) {
      return false;
    }
    if (getMajor() != null ? !getMajor().equals(that.getMajor()) : that.getMajor() != null) {
      return false;
    }
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
    result = 31 * result + (getMajor() != null ? getMajor().hashCode() : 0);
    result = 31 * result + (getType() != null ? getType().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DoctorListFragmentArgs{"
        + "major=" + getMajor()
        + ", type=" + getType()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(DoctorListFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public DoctorListFragmentArgs build() {
      DoctorListFragmentArgs result = new DoctorListFragmentArgs(arguments);
      return result;
    }

    @NonNull
    public Builder setMajor(@NonNull String major) {
      if (major == null) {
        throw new IllegalArgumentException("Argument \"major\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("major", major);
      return this;
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
    public String getMajor() {
      return (String) arguments.get("major");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getType() {
      return (String) arguments.get("type");
    }
  }
}
