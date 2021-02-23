package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DoctorListItemBindingImpl extends DoctorListItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.middleSectionLinear, 5);
        sViewsWithIds.put(R.id.nextImageView, 6);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mListenerOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public DoctorListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private DoctorListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.RatingBar) bindings[4]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.ImageView) bindings[6]
            );
        this.doctorImage.setTag(null);
        this.doctorLocation.setTag(null);
        this.doctorName.setTag(null);
        this.doctorRating.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
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
        if (BR.listener == variableId) {
            setListener((com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick) variable);
        }
        else if (BR.data == variableId) {
            setData((com.aligmohammad.doctorapp.data.model.Doctor) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setData(@Nullable com.aligmohammad.doctorapp.data.model.Doctor Data) {
        this.mData = Data;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.data);
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
        int androidxDatabindingViewDataBindingSafeUnboxDataRating = 0;
        java.lang.String dataImageUrl = null;
        java.lang.Integer dataRating = null;
        java.lang.String dataLocationName = null;
        android.view.View.OnClickListener listenerOnClickAndroidViewViewOnClickListener = null;
        com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick listener = mListener;
        java.lang.String dataName = null;
        com.aligmohammad.doctorapp.data.model.Doctor data = mData;

        if ((dirtyFlags & 0x5L) != 0) {



                if (listener != null) {
                    // read listener::onClick
                    listenerOnClickAndroidViewViewOnClickListener = (((mListenerOnClickAndroidViewViewOnClickListener == null) ? (mListenerOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mListenerOnClickAndroidViewViewOnClickListener).setValue(listener));
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (data != null) {
                    // read data.imageUrl
                    dataImageUrl = data.getImageUrl();
                    // read data.rating
                    dataRating = data.getRating();
                    // read data.locationName
                    dataLocationName = data.getLocationName();
                    // read data.name
                    dataName = data.getName();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(data.rating)
                androidxDatabindingViewDataBindingSafeUnboxDataRating = androidx.databinding.ViewDataBinding.safeUnbox(dataRating);
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.aligmohammad.doctorapp.util.ViewsKt.loadImage(this.doctorImage, dataImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorLocation, dataLocationName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorName, dataName);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.doctorRating, androidxDatabindingViewDataBindingSafeUnboxDataRating);
            this.mboundView0.setTag(dataName);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(listenerOnClickAndroidViewViewOnClickListener);
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
        flag 0 (0x1L): listener
        flag 1 (0x2L): data
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}