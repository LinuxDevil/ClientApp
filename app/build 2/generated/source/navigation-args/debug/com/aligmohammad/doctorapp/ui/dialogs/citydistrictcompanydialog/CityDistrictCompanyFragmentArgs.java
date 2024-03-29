package com.aligmohammad.doctorapp.ui.dialogs.citydistrictcompanydialog;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CityDistrictCompanyFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CityDistrictCompanyFragmentArgs() {
  }

  private CityDistrictCompanyFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CityDistrictCompanyFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CityDistrictCompanyFragmentArgs __result = new CityDistrictCompanyFragmentArgs();
    bundle.setClassLoader(CityDistrictCompanyFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("type")) {
      String type;
      type = bundle.getString("type");
      if (type == null) {
        throw new IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("type", type);
    } else {
      __result.arguments.put("type", "labs");
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
    } else {
      __result.putString("type", "labs");
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
    CityDistrictCompanyFragmentArgs that = (CityDistrictCompanyFragmentArgs) object;
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
    return "CityDistrictCompanyFragmentArgs{"
        + "type=" + getType()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    public Builder(CityDistrictCompanyFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CityDistrictCompanyFragmentArgs build() {
      CityDistrictCompanyFragmentArgs result = new CityDistrictCompanyFragmentArgs(arguments);
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
