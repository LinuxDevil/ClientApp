package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DoctorMajorItemBindingImpl extends DoctorMajorItemBinding  {

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
    private final androidx.constraintlayout.motion.widget.MotionLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mListenerOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public DoctorMajorItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private DoctorMajorItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.profileImage.setTag(null);
        this.title.setTag(null);
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
        if (BR.menuItem == variableId) {
            setMenuItem((com.aligmohammad.doctorapp.data.model.RecyclerMenuItem) variable);
        }
        else if (BR.listener == variableId) {
            setListener((com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMenuItem(@Nullable com.aligmohammad.doctorapp.data.model.RecyclerMenuItem MenuItem) {
        this.mMenuItem = MenuItem;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.menuItem);
        super.requestRebind();
    }
    public void setListener(@Nullable com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
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
        java.lang.String menuItemName = null;
        com.aligmohammad.doctorapp.data.model.RecyclerMenuItem menuItem = mMenuItem;
        android.view.View.OnClickListener listenerOnClickAndroidViewViewOnClickListener = null;
        com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick listener = mListener;

        if ((dirtyFlags & 0x5L) != 0) {



                if (menuItem != null) {
                    // read menuItem.imageUrl
                    menuItemImageUrl = menuItem.getImageUrl();
                    // read menuItem.name
                    menuItemName = menuItem.getName();
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (listener != null) {
                    // read listener::onClick
                    listenerOnClickAndroidViewViewOnClickListener = (((mListenerOnClickAndroidViewViewOnClickListener == null) ? (mListenerOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mListenerOnClickAndroidViewViewOnClickListener).setValue(listener));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(listenerOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.aligmohammad.doctorapp.util.ViewsKt.loadImage(this.profileImage, menuItemImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.title, menuItemName);
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
        flag 0 (0x1L): menuItem
        flag 1 (0x2L): listener
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}