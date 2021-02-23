package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RequestDoctorNurseBottomSheetFragmentBindingImpl extends RequestDoctorNurseBottomSheetFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.header, 2);
        sViewsWithIds.put(R.id.title, 3);
        sViewsWithIds.put(R.id.dateTextView, 4);
        sViewsWithIds.put(R.id.dateEditText, 5);
        sViewsWithIds.put(R.id.districtTextView, 6);
        sViewsWithIds.put(R.id.districtSpinner, 7);
        sViewsWithIds.put(R.id.insuranceCompanyTextViewTextView, 8);
        sViewsWithIds.put(R.id.insuranceCompanyTextViewSpinner, 9);
        sViewsWithIds.put(R.id.totalTextView, 10);
        sViewsWithIds.put(R.id.confirm_button, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.motion.widget.MotionLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mListenerOnBackButtonClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public RequestDoctorNurseBottomSheetFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private RequestDoctorNurseBottomSheetFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[11]
            , (android.widget.Spinner) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.Spinner) bindings[7]
            , (android.widget.TextView) bindings[6]
            , (android.widget.LinearLayout) bindings[2]
            , (android.widget.Spinner) bindings[9]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[10]
            );
        this.backButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0];
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
            setListener((com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.requestdoctornurse.RequestDoctorNurseBottomSheetViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.aligmohammad.doctorapp.ui.dialogs.doctorconsulting.requestdoctornurse.RequestDoctorNurseBottomSheetViewModel ViewModel) {
        this.mViewModel = ViewModel;
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
        android.view.View.OnClickListener listenerOnBackButtonClickedAndroidViewViewOnClickListener = null;
        com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract listener = mListener;

        if ((dirtyFlags & 0x5L) != 0) {



                if (listener != null) {
                    // read listener::onBackButtonClicked
                    listenerOnBackButtonClickedAndroidViewViewOnClickListener = (((mListenerOnBackButtonClickedAndroidViewViewOnClickListener == null) ? (mListenerOnBackButtonClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mListenerOnBackButtonClickedAndroidViewViewOnClickListener).setValue(listener));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.backButton.setOnClickListener(listenerOnBackButtonClickedAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract value;
        public OnClickListenerImpl setValue(com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onBackButtonClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): listener
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}