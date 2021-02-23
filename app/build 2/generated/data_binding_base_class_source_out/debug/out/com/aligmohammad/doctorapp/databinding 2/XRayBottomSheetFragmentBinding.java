// Generated by data binding compiler. Do not edit!
package com.aligmohammad.doctorapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract;
import com.aligmohammad.doctorapp.ui.dialogs.xraychoice.XRayBottomSheetViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class XRayBottomSheetFragmentBinding extends ViewDataBinding {
  @NonNull
  public final Button backButton;

  @NonNull
  public final Button confirmButton;

  @NonNull
  public final EditText dateEditText;

  @NonNull
  public final TextView dateTextView;

  @NonNull
  public final LinearLayout header;

  @NonNull
  public final Spinner testSpinner;

  @NonNull
  public final TextView testsView;

  @NonNull
  public final EditText timeEditText;

  @NonNull
  public final TextView timeTextView;

  @NonNull
  public final TextView title;

  @Bindable
  protected OnDialogInteract mListener;

  @Bindable
  protected XRayBottomSheetViewModel mViewModel;

  protected XRayBottomSheetFragmentBinding(Object _bindingComponent, View _root,
      int _localFieldCount, Button backButton, Button confirmButton, EditText dateEditText,
      TextView dateTextView, LinearLayout header, Spinner testSpinner, TextView testsView,
      EditText timeEditText, TextView timeTextView, TextView title) {
    super(_bindingComponent, _root, _localFieldCount);
    this.backButton = backButton;
    this.confirmButton = confirmButton;
    this.dateEditText = dateEditText;
    this.dateTextView = dateTextView;
    this.header = header;
    this.testSpinner = testSpinner;
    this.testsView = testsView;
    this.timeEditText = timeEditText;
    this.timeTextView = timeTextView;
    this.title = title;
  }

  public abstract void setListener(@Nullable OnDialogInteract listener);

  @Nullable
  public OnDialogInteract getListener() {
    return mListener;
  }

  public abstract void setViewModel(@Nullable XRayBottomSheetViewModel viewModel);

  @Nullable
  public XRayBottomSheetViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static XRayBottomSheetFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.x_ray_bottom_sheet_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static XRayBottomSheetFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<XRayBottomSheetFragmentBinding>inflateInternal(inflater, R.layout.x_ray_bottom_sheet_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static XRayBottomSheetFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.x_ray_bottom_sheet_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static XRayBottomSheetFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<XRayBottomSheetFragmentBinding>inflateInternal(inflater, R.layout.x_ray_bottom_sheet_fragment, null, false, component);
  }

  public static XRayBottomSheetFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static XRayBottomSheetFragmentBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (XRayBottomSheetFragmentBinding)bind(component, view, R.layout.x_ray_bottom_sheet_fragment);
  }
}