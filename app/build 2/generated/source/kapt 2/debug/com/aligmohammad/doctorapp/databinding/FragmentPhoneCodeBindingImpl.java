package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentPhoneCodeBindingImpl extends FragmentPhoneCodeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.success, 3);
        sViewsWithIds.put(R.id.logo, 4);
        sViewsWithIds.put(R.id.phoneCodeTextView, 5);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.motion.widget.MotionLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mViewModelOnConfirmClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener phoneCodeEditTextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.phoneCode
            //         is viewModel.setPhoneCode((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(phoneCodeEditText);
            // localize variables for thread safety
            // viewModel.phoneCode
            java.lang.String viewModelPhoneCode = null;
            // viewModel
            com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setPhoneCode(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentPhoneCodeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentPhoneCodeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[4]
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[5]
            , (android.widget.Button) bindings[2]
            , (android.widget.ImageView) bindings[3]
            );
        this.mboundView0 = (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.phoneCodeEditText.setTag(null);
        this.registerButton.setTag(null);
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
            setViewModel((com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel ViewModel) {
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
        java.lang.String viewModelPhoneCode = null;
        com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel viewModel = mViewModel;
        android.view.View.OnClickListener viewModelOnConfirmClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel.phoneCode
                    viewModelPhoneCode = viewModel.getPhoneCode();
                    // read viewModel::onConfirmClicked
                    viewModelOnConfirmClickedAndroidViewViewOnClickListener = (((mViewModelOnConfirmClickedAndroidViewViewOnClickListener == null) ? (mViewModelOnConfirmClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewModelOnConfirmClickedAndroidViewViewOnClickListener).setValue(viewModel));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.phoneCodeEditText, viewModelPhoneCode);
            this.registerButton.setOnClickListener(viewModelOnConfirmClickedAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.phoneCodeEditText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, phoneCodeEditTextandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel value;
        public OnClickListenerImpl setValue(com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel value) {
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