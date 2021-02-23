package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LabListItemBindingImpl extends LabListItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.middleSectionLinear, 7);
        sViewsWithIds.put(R.id.middleRightSectionLinear, 8);
        sViewsWithIds.put(R.id.midTopLinear, 9);
        sViewsWithIds.put(R.id.noOfVisitorsTextView, 10);
        sViewsWithIds.put(R.id.midBottomLinear, 11);
        sViewsWithIds.put(R.id.noOfWatchersTextView, 12);
        sViewsWithIds.put(R.id.nextImageView, 13);
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mListenerOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public LabListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private LabListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.RatingBar) bindings[4]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[7]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[12]
            );
        this.doctorImage.setTag(null);
        this.doctorLocation.setTag(null);
        this.doctorName.setTag(null);
        this.doctorRating.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.noOfVisitors.setTag(null);
        this.noOfWatchers.setTag(null);
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
            setData((com.aligmohammad.doctorapp.data.model.Place) variable);
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
    public void setData(@Nullable com.aligmohammad.doctorapp.data.model.Place Data) {
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
        java.lang.Integer dataWatchers = null;
        int androidxDatabindingViewDataBindingSafeUnboxDataRating = 0;
        java.lang.String dataImageUrl = null;
        java.lang.Integer dataRating = null;
        android.view.View.OnClickListener listenerOnClickAndroidViewViewOnClickListener = null;
        com.aligmohammad.doctorapp.ui.adapters.OnMenuItemClick listener = mListener;
        com.aligmohammad.doctorapp.data.model.Place data = mData;
        java.lang.String dataVisitorsToString = null;
        java.lang.Integer dataVisitors = null;
        java.lang.String dataName = null;
        java.lang.String dataWatchersToString = null;
        java.lang.String dataLocation = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (listener != null) {
                    // read listener::onClick
                    listenerOnClickAndroidViewViewOnClickListener = (((mListenerOnClickAndroidViewViewOnClickListener == null) ? (mListenerOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mListenerOnClickAndroidViewViewOnClickListener).setValue(listener));
                }
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (data != null) {
                    // read data.watchers
                    dataWatchers = data.getWatchers();
                    // read data.imageUrl
                    dataImageUrl = data.getImageUrl();
                    // read data.rating
                    dataRating = data.getRating();
                    // read data.visitors
                    dataVisitors = data.getVisitors();
                    // read data.name
                    dataName = data.getName();
                    // read data.location
                    dataLocation = data.getLocation();
                }


                if (dataWatchers != null) {
                    // read data.watchers.toString()
                    dataWatchersToString = dataWatchers.toString();
                }
                // read androidx.databinding.ViewDataBinding.safeUnbox(data.rating)
                androidxDatabindingViewDataBindingSafeUnboxDataRating = androidx.databinding.ViewDataBinding.safeUnbox(dataRating);
                if (dataVisitors != null) {
                    // read data.visitors.toString()
                    dataVisitorsToString = dataVisitors.toString();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.aligmohammad.doctorapp.util.ViewsKt.loadImage(this.doctorImage, dataImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorLocation, dataLocation);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorName, dataName);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.doctorRating, androidxDatabindingViewDataBindingSafeUnboxDataRating);
            this.mboundView0.setTag(dataName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.noOfVisitors, dataVisitorsToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.noOfWatchers, dataWatchersToString);
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