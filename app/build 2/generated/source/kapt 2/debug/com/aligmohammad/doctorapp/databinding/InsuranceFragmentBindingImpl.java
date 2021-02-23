package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class InsuranceFragmentBindingImpl extends InsuranceFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.logo, 2);
        sViewsWithIds.put(R.id.insuranceTextView, 3);
        sViewsWithIds.put(R.id.insuranceCompanySpinner, 4);
        sViewsWithIds.put(R.id.insuranceNumberTextView, 5);
        sViewsWithIds.put(R.id.insuranceNumberEditText, 6);
        sViewsWithIds.put(R.id.skipButton, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mViewModelOnConfirmClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public InsuranceFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private InsuranceFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.Spinner) bindings[4]
            , (android.widget.EditText) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.Button) bindings[7]
            );
        this.confirmButton.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.viewModel == variableId) {
            setViewModel((com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.viewModel);
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
        com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceViewModel viewModel = mViewModel;
        android.view.View.OnClickListener viewModelOnConfirmClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel::onConfirmClicked
                    viewModelOnConfirmClickedAndroidViewViewOnClickListener = (((mViewModelOnConfirmClickedAndroidViewViewOnClickListener == null) ? (mViewModelOnConfirmClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewModelOnConfirmClickedAndroidViewViewOnClickListener).setValue(viewModel));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.confirmButton.setOnClickListener(viewModelOnConfirmClickedAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceViewModel value;
        public OnClickListenerImpl setValue(com.aligmohammad.doctorapp.ui.fragments.insurancefragment.InsuranceViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onConfirmClicked(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}