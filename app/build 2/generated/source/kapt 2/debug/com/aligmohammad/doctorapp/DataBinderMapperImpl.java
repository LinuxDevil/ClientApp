package com.aligmohammad.doctorapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.aligmohammad.doctorapp.databinding.BottomSheetGovernmentHospitalChooseBindingImpl;
import com.aligmohammad.doctorapp.databinding.CityDistrictCompanyFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.DateAndTimeBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorConsultResultFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorConsultingBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorListFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorListItemBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorMajorFragmentItemListBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorMajorItemBindingImpl;
import com.aligmohammad.doctorapp.databinding.DoctorProfileFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.ExternalLabBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.FragmentLoginBindingImpl;
import com.aligmohammad.doctorapp.databinding.FragmentPhoneCodeBindingImpl;
import com.aligmohammad.doctorapp.databinding.GovernmentHospitalsFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.HomeFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.HomeScreenMenuItemBindingImpl;
import com.aligmohammad.doctorapp.databinding.InsuranceFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.LabListItemBindingImpl;
import com.aligmohammad.doctorapp.databinding.LabsBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.MedicineItemBindingImpl;
import com.aligmohammad.doctorapp.databinding.MedicineOrderFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.NaturalistBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.OpertaionBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.PharmacyRicottaBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.PrivateHospitalsFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.RequestDoctorNurseBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.SymptomsBottomSheetFragmentBindingImpl;
import com.aligmohammad.doctorapp.databinding.XRayBottomSheetFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_BOTTOMSHEETGOVERNMENTHOSPITALCHOOSE = 1;

  private static final int LAYOUT_CITYDISTRICTCOMPANYFRAGMENT = 2;

  private static final int LAYOUT_DATEANDTIMEBOTTOMSHEETFRAGMENT = 3;

  private static final int LAYOUT_DOCTORCONSULTRESULTFRAGMENT = 4;

  private static final int LAYOUT_DOCTORCONSULTINGBOTTOMSHEETFRAGMENT = 5;

  private static final int LAYOUT_DOCTORLISTFRAGMENT = 6;

  private static final int LAYOUT_DOCTORLISTITEM = 7;

  private static final int LAYOUT_DOCTORMAJORFRAGMENTITEMLIST = 8;

  private static final int LAYOUT_DOCTORMAJORITEM = 9;

  private static final int LAYOUT_DOCTORPROFILEFRAGMENT = 10;

  private static final int LAYOUT_EXTERNALLABBOTTOMSHEETFRAGMENT = 11;

  private static final int LAYOUT_FRAGMENTLOGIN = 12;

  private static final int LAYOUT_FRAGMENTPHONECODE = 13;

  private static final int LAYOUT_GOVERNMENTHOSPITALSFRAGMENT = 14;

  private static final int LAYOUT_HOMEFRAGMENT = 15;

  private static final int LAYOUT_HOMESCREENMENUITEM = 16;

  private static final int LAYOUT_INSURANCEFRAGMENT = 17;

  private static final int LAYOUT_LABLISTITEM = 18;

  private static final int LAYOUT_LABSBOTTOMSHEETFRAGMENT = 19;

  private static final int LAYOUT_MEDICINEITEM = 20;

  private static final int LAYOUT_MEDICINEORDERFRAGMENT = 21;

  private static final int LAYOUT_NATURALISTBOTTOMSHEETFRAGMENT = 22;

  private static final int LAYOUT_OPERTAIONBOTTOMSHEETFRAGMENT = 23;

  private static final int LAYOUT_PHARMACYRICOTTABOTTOMSHEETFRAGMENT = 24;

  private static final int LAYOUT_PRIVATEHOSPITALSFRAGMENT = 25;

  private static final int LAYOUT_REQUESTDOCTORNURSEBOTTOMSHEETFRAGMENT = 26;

  private static final int LAYOUT_SYMPTOMSBOTTOMSHEETFRAGMENT = 27;

  private static final int LAYOUT_XRAYBOTTOMSHEETFRAGMENT = 28;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(28);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.bottom_sheet_government_hospital_choose, LAYOUT_BOTTOMSHEETGOVERNMENTHOSPITALCHOOSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.city_district_company_fragment, LAYOUT_CITYDISTRICTCOMPANYFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.date_and_time_bottom_sheet_fragment, LAYOUT_DATEANDTIMEBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_consult_result_fragment, LAYOUT_DOCTORCONSULTRESULTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_consulting_bottom_sheet_fragment, LAYOUT_DOCTORCONSULTINGBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_list_fragment, LAYOUT_DOCTORLISTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_list_item, LAYOUT_DOCTORLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_major_fragment_item_list, LAYOUT_DOCTORMAJORFRAGMENTITEMLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_major_item, LAYOUT_DOCTORMAJORITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.doctor_profile_fragment, LAYOUT_DOCTORPROFILEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.external_lab_bottom_sheet_fragment, LAYOUT_EXTERNALLABBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.fragment_login, LAYOUT_FRAGMENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.fragment_phone_code, LAYOUT_FRAGMENTPHONECODE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.government_hospitals_fragment, LAYOUT_GOVERNMENTHOSPITALSFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.home_fragment, LAYOUT_HOMEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.home_screen_menu_item, LAYOUT_HOMESCREENMENUITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.insurance_fragment, LAYOUT_INSURANCEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.lab_list_item, LAYOUT_LABLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.labs_bottom_sheet_fragment, LAYOUT_LABSBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.medicine_item, LAYOUT_MEDICINEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.medicine_order_fragment, LAYOUT_MEDICINEORDERFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.naturalist_bottom_sheet_fragment, LAYOUT_NATURALISTBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.opertaion_bottom_sheet_fragment, LAYOUT_OPERTAIONBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.pharmacy_ricotta_bottom_sheet_fragment, LAYOUT_PHARMACYRICOTTABOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.private_hospitals_fragment, LAYOUT_PRIVATEHOSPITALSFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.request_doctor_nurse_bottom_sheet_fragment, LAYOUT_REQUESTDOCTORNURSEBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.symptoms_bottom_sheet_fragment, LAYOUT_SYMPTOMSBOTTOMSHEETFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.aligmohammad.doctorapp.R.layout.x_ray_bottom_sheet_fragment, LAYOUT_XRAYBOTTOMSHEETFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_BOTTOMSHEETGOVERNMENTHOSPITALCHOOSE: {
          if ("layout/bottom_sheet_government_hospital_choose_0".equals(tag)) {
            return new BottomSheetGovernmentHospitalChooseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_government_hospital_choose is invalid. Received: " + tag);
        }
        case  LAYOUT_CITYDISTRICTCOMPANYFRAGMENT: {
          if ("layout/city_district_company_fragment_0".equals(tag)) {
            return new CityDistrictCompanyFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for city_district_company_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DATEANDTIMEBOTTOMSHEETFRAGMENT: {
          if ("layout/date_and_time_bottom_sheet_fragment_0".equals(tag)) {
            return new DateAndTimeBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for date_and_time_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORCONSULTRESULTFRAGMENT: {
          if ("layout/doctor_consult_result_fragment_0".equals(tag)) {
            return new DoctorConsultResultFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_consult_result_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORCONSULTINGBOTTOMSHEETFRAGMENT: {
          if ("layout/doctor_consulting_bottom_sheet_fragment_0".equals(tag)) {
            return new DoctorConsultingBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_consulting_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORLISTFRAGMENT: {
          if ("layout/doctor_list_fragment_0".equals(tag)) {
            return new DoctorListFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_list_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORLISTITEM: {
          if ("layout/doctor_list_item_0".equals(tag)) {
            return new DoctorListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORMAJORFRAGMENTITEMLIST: {
          if ("layout/doctor_major_fragment_item_list_0".equals(tag)) {
            return new DoctorMajorFragmentItemListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_major_fragment_item_list is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORMAJORITEM: {
          if ("layout/doctor_major_item_0".equals(tag)) {
            return new DoctorMajorItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_major_item is invalid. Received: " + tag);
        }
        case  LAYOUT_DOCTORPROFILEFRAGMENT: {
          if ("layout/doctor_profile_fragment_0".equals(tag)) {
            return new DoctorProfileFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for doctor_profile_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_EXTERNALLABBOTTOMSHEETFRAGMENT: {
          if ("layout/external_lab_bottom_sheet_fragment_0".equals(tag)) {
            return new ExternalLabBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for external_lab_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGIN: {
          if ("layout/fragment_login_0".equals(tag)) {
            return new FragmentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPHONECODE: {
          if ("layout/fragment_phone_code_0".equals(tag)) {
            return new FragmentPhoneCodeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_phone_code is invalid. Received: " + tag);
        }
        case  LAYOUT_GOVERNMENTHOSPITALSFRAGMENT: {
          if ("layout/government_hospitals_fragment_0".equals(tag)) {
            return new GovernmentHospitalsFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for government_hospitals_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_HOMEFRAGMENT: {
          if ("layout/home_fragment_0".equals(tag)) {
            return new HomeFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for home_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_HOMESCREENMENUITEM: {
          if ("layout/home_screen_menu_item_0".equals(tag)) {
            return new HomeScreenMenuItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for home_screen_menu_item is invalid. Received: " + tag);
        }
        case  LAYOUT_INSURANCEFRAGMENT: {
          if ("layout/insurance_fragment_0".equals(tag)) {
            return new InsuranceFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for insurance_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_LABLISTITEM: {
          if ("layout/lab_list_item_0".equals(tag)) {
            return new LabListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for lab_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LABSBOTTOMSHEETFRAGMENT: {
          if ("layout/labs_bottom_sheet_fragment_0".equals(tag)) {
            return new LabsBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for labs_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_MEDICINEITEM: {
          if ("layout/medicine_item_0".equals(tag)) {
            return new MedicineItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for medicine_item is invalid. Received: " + tag);
        }
        case  LAYOUT_MEDICINEORDERFRAGMENT: {
          if ("layout/medicine_order_fragment_0".equals(tag)) {
            return new MedicineOrderFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for medicine_order_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_NATURALISTBOTTOMSHEETFRAGMENT: {
          if ("layout/naturalist_bottom_sheet_fragment_0".equals(tag)) {
            return new NaturalistBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for naturalist_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_OPERTAIONBOTTOMSHEETFRAGMENT: {
          if ("layout/opertaion_bottom_sheet_fragment_0".equals(tag)) {
            return new OpertaionBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for opertaion_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_PHARMACYRICOTTABOTTOMSHEETFRAGMENT: {
          if ("layout/pharmacy_ricotta_bottom_sheet_fragment_0".equals(tag)) {
            return new PharmacyRicottaBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for pharmacy_ricotta_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_PRIVATEHOSPITALSFRAGMENT: {
          if ("layout/private_hospitals_fragment_0".equals(tag)) {
            return new PrivateHospitalsFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for private_hospitals_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_REQUESTDOCTORNURSEBOTTOMSHEETFRAGMENT: {
          if ("layout/request_doctor_nurse_bottom_sheet_fragment_0".equals(tag)) {
            return new RequestDoctorNurseBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for request_doctor_nurse_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_SYMPTOMSBOTTOMSHEETFRAGMENT: {
          if ("layout/symptoms_bottom_sheet_fragment_0".equals(tag)) {
            return new SymptomsBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for symptoms_bottom_sheet_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_XRAYBOTTOMSHEETFRAGMENT: {
          if ("layout/x_ray_bottom_sheet_fragment_0".equals(tag)) {
            return new XRayBottomSheetFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for x_ray_bottom_sheet_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(8);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "clickListener");
      sKeys.put(2, "data");
      sKeys.put(3, "doctor");
      sKeys.put(4, "listener");
      sKeys.put(5, "medicine");
      sKeys.put(6, "menuItem");
      sKeys.put(7, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(28);

    static {
      sKeys.put("layout/bottom_sheet_government_hospital_choose_0", com.aligmohammad.doctorapp.R.layout.bottom_sheet_government_hospital_choose);
      sKeys.put("layout/city_district_company_fragment_0", com.aligmohammad.doctorapp.R.layout.city_district_company_fragment);
      sKeys.put("layout/date_and_time_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.date_and_time_bottom_sheet_fragment);
      sKeys.put("layout/doctor_consult_result_fragment_0", com.aligmohammad.doctorapp.R.layout.doctor_consult_result_fragment);
      sKeys.put("layout/doctor_consulting_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.doctor_consulting_bottom_sheet_fragment);
      sKeys.put("layout/doctor_list_fragment_0", com.aligmohammad.doctorapp.R.layout.doctor_list_fragment);
      sKeys.put("layout/doctor_list_item_0", com.aligmohammad.doctorapp.R.layout.doctor_list_item);
      sKeys.put("layout/doctor_major_fragment_item_list_0", com.aligmohammad.doctorapp.R.layout.doctor_major_fragment_item_list);
      sKeys.put("layout/doctor_major_item_0", com.aligmohammad.doctorapp.R.layout.doctor_major_item);
      sKeys.put("layout/doctor_profile_fragment_0", com.aligmohammad.doctorapp.R.layout.doctor_profile_fragment);
      sKeys.put("layout/external_lab_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.external_lab_bottom_sheet_fragment);
      sKeys.put("layout/fragment_login_0", com.aligmohammad.doctorapp.R.layout.fragment_login);
      sKeys.put("layout/fragment_phone_code_0", com.aligmohammad.doctorapp.R.layout.fragment_phone_code);
      sKeys.put("layout/government_hospitals_fragment_0", com.aligmohammad.doctorapp.R.layout.government_hospitals_fragment);
      sKeys.put("layout/home_fragment_0", com.aligmohammad.doctorapp.R.layout.home_fragment);
      sKeys.put("layout/home_screen_menu_item_0", com.aligmohammad.doctorapp.R.layout.home_screen_menu_item);
      sKeys.put("layout/insurance_fragment_0", com.aligmohammad.doctorapp.R.layout.insurance_fragment);
      sKeys.put("layout/lab_list_item_0", com.aligmohammad.doctorapp.R.layout.lab_list_item);
      sKeys.put("layout/labs_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.labs_bottom_sheet_fragment);
      sKeys.put("layout/medicine_item_0", com.aligmohammad.doctorapp.R.layout.medicine_item);
      sKeys.put("layout/medicine_order_fragment_0", com.aligmohammad.doctorapp.R.layout.medicine_order_fragment);
      sKeys.put("layout/naturalist_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.naturalist_bottom_sheet_fragment);
      sKeys.put("layout/opertaion_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.opertaion_bottom_sheet_fragment);
      sKeys.put("layout/pharmacy_ricotta_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.pharmacy_ricotta_bottom_sheet_fragment);
      sKeys.put("layout/private_hospitals_fragment_0", com.aligmohammad.doctorapp.R.layout.private_hospitals_fragment);
      sKeys.put("layout/request_doctor_nurse_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.request_doctor_nurse_bottom_sheet_fragment);
      sKeys.put("layout/symptoms_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.symptoms_bottom_sheet_fragment);
      sKeys.put("layout/x_ray_bottom_sheet_fragment_0", com.aligmohammad.doctorapp.R.layout.x_ray_bottom_sheet_fragment);
    }
  }
}
