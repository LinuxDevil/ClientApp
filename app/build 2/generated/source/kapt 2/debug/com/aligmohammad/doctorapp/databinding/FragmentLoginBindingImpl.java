package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLoginBindingImpl extends FragmentLoginBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.logo, 4);
        sViewsWithIds.put(R.id.usernameTextView, 5);
        sViewsWithIds.put(R.id.phoneTextView, 6);
    }
    // views
    // variables
    // values
    // listeners
    private OnClickListenerImpl mViewModelOnRegisterClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener phoneEditTextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.phoneNumber
            //         is viewModel.setPhoneNumber((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(phoneEditText);
            // localize variables for thread safety
            // viewModel.phoneNumber
            java.lang.String viewModelPhoneNumber = null;
            // viewModel
            com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setPhoneNumber(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener usernameEditTextandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.username
            //         is viewModel.setUsername((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(usernameEditText);
            // localize variables for thread safety
            // viewModel
            com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel viewModel = mViewModel;
            // viewModel.username
            java.lang.String viewModelUsername = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setUsername(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.EditText) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.Button) bindings[3]
            , (android.widget.EditText) bindings[1]
            , (android.widget.TextView) bindings[5]
            );
        this.loginFragmentMotionLayout.setTag(null);
        this.phoneEditText.setTag(null);
        this.registerButton.setTag(null);
        this.usernameEditText.setTag(null);
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
        android.view.View.OnClickListener viewModelOnRegisterClickedAndroidViewViewOnClickListener = null;
        java.lang.String viewModelPhoneNumber = null;
        com.aligmohammad.doctorapp.ui.fragments.authframent.AuthViewModel viewModel = mViewModel;
        java.lang.String viewModelUsername = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (viewModel != null) {
                    // read viewModel::onRegisterClicked
                    viewModelOnRegisterClickedAndroidViewViewOnClickListener = (((mViewModelOnRegisterClickedAndroidViewViewOnClickListener == null) ? (mViewModelOnRegisterClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mViewModelOnRegisterClickedAndroidViewViewOnClickListener).setValue(viewModel));
                    // read viewModel.phoneNumber
                    viewModelPhoneNumber = viewModel.getPhoneNumber();
                    // read viewModel.username
                    viewModelUsername = viewModel.getUsername();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.phoneEditText, viewModelPhoneNumber);
            this.registerButton.setOnClickListener(viewModelOnRegisterClickedAndroidViewViewOnClickListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.usernameEditText, viewModelUsername);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.phoneEditText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, phoneEditTextandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.usernameEditText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, usernameEditTextandroidTextAttrChanged);
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
            this.value.onRegisterClicked(arg0); 
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