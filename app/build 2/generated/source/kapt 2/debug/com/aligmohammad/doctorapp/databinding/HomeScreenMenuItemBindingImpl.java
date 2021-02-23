package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class HomeScreenMenuItemBindingImpl extends HomeScreenMenuItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mClickListenerOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public HomeScreenMenuItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private HomeScreenMenuItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.itemImage.setTag(null);
        this.itemName.setTag(null);
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.clickListener == variableId) {
            setClickListener((com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick) variable);
        }
        else if (BR.menuItem == variableId) {
            setMenuItem((com.aligmohammad.doctorapp.data.model.RecyclerMenuItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setClickListener(@Nullable com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick ClickListener) {
        this.mClickListener = ClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.clickListener);
        super.requestRebind();
    }
    public void setMenuItem(@Nullable com.aligmohammad.doctorapp.data.model.RecyclerMenuItem MenuItem) {
        this.mMenuItem = MenuItem;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.menuItem);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String menuItemImageUrl = null;
        com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick clickListener = mClickListener;
        java.lang.String menuItemName = null;
        com.aligmohammad.doctorapp.data.model.RecyclerMenuItem menuItem = mMenuItem;
        android.view.View.OnClickListener clickListenerOnClickAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (clickListener != null) {
                    // read clickListener::onClick
                    clickListenerOnClickAndroidViewViewOnClickListener = (((mClickListenerOnClickAndroidViewViewOnClickListener == null) ? (mClickListenerOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mClickListenerOnClickAndroidViewViewOnClickListener).setValue(clickListener));
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (menuItem != null) {
                    // read menuItem.imageUrl
                    menuItemImageUrl = menuItem.getImageUrl();
                    // read menuItem.name
                    menuItemName = menuItem.getName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.aligmohammad.doctorapp.util.ViewsKt.loadImage(this.itemImage, menuItemImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.itemName, menuItemName);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(clickListenerOnClickAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick value;
        public OnClickListenerImpl setValue(com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): clickListener
        flag 1 (0x2L): menuItem
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}