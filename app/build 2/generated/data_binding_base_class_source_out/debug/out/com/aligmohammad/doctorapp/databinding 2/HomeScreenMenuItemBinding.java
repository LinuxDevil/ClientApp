// Generated by data binding compiler. Do not edit!
package com.aligmohammad.doctorapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.data.model.RecyclerMenuItem;
import com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class HomeScreenMenuItemBinding extends ViewDataBinding {
  @NonNull
  public final ImageView itemImage;

  @NonNull
  public final TextView itemName;

  @Bindable
  protected RecyclerMenuItem mMenuItem;

  @Bindable
  protected OnMenuItemClick mClickListener;

  protected HomeScreenMenuItemBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView itemImage, TextView itemName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.itemImage = itemImage;
    this.itemName = itemName;
  }

  public abstract void setMenuItem(@Nullable RecyclerMenuItem menuItem);

  @Nullable
  public RecyclerMenuItem getMenuItem() {
    return mMenuItem;
  }

  public abstract void setClickListener(@Nullable OnMenuItemClick clickListener);

  @Nullable
  public OnMenuItemClick getClickListener() {
    return mClickListener;
  }

  @NonNull
  public static HomeScreenMenuItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.home_screen_menu_item, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HomeScreenMenuItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HomeScreenMenuItemBinding>inflateInternal(inflater, R.layout.home_screen_menu_item, root, attachToRoot, component);
  }

  @NonNull
  public static HomeScreenMenuItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.home_screen_menu_item, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HomeScreenMenuItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<HomeScreenMenuItemBinding>inflateInternal(inflater, R.layout.home_screen_menu_item, null, false, component);
  }

  public static HomeScreenMenuItemBinding bind(@NonNull View view) {
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
  public static HomeScreenMenuItemBinding bind(@NonNull View view, @Nullable Object component) {
    return (HomeScreenMenuItemBinding)bind(component, view, R.layout.home_screen_menu_item);
  }
}