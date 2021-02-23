package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class GovernmentHospitalsFragmentBindingImpl extends GovernmentHospitalsFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.header, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mListenerOnButtonClickedAndroidViewViewOnClickListener;
    private OnClickListenerImpl1 mListenerOnBackButtonClickedAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public GovernmentHospitalsFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private GovernmentHospitalsFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.LinearLayout) bindings[6]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[5]
            , (android.widget.Button) bindings[4]
            );
        this.backButton.setTag(null);
        this.external.setTag(null);
        this.labs.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.naturalist.setTag(null);
        this.xray.setTag(null);
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
            setViewModel((com.aligmohammad.doctorapp.ui.dialogs.govermenthospitals.GovernmentHospitalsViewModel) variable);
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
    public void setViewModel(@Nullable com.aligmohammad.doctorapp.ui.dialogs.govermenthospitals.GovernmentHospitalsViewModel ViewModel) {
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
        android.view.View.OnClickListener listenerOnButtonClickedAndroidViewViewOnClickListener = null;
        com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract listener = mListener;
        android.view.View.OnClickListener listenerOnBackButtonClickedAndroidViewViewOnClickListener = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (listener != null) {
                    // read listener::onButtonClicked
                    listenerOnButtonClickedAndroidViewViewOnClickListener = (((mListenerOnButtonClickedAndroidViewViewOnClickListener == null) ? (mListenerOnButtonClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mListenerOnButtonClickedAndroidViewViewOnClickListener).setValue(listener));
                    // read listener::onBackButtonClicked
                    listenerOnBackButtonClickedAndroidViewViewOnClickListener = (((mListenerOnBackButtonClickedAndroidViewViewOnClickListener == null) ? (mListenerOnBackButtonClickedAndroidViewViewOnClickListener = new OnClickListenerImpl1()) : mListenerOnBackButtonClickedAndroidViewViewOnClickListener).setValue(listener));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.backButton.setOnClickListener(listenerOnBackButtonClickedAndroidViewViewOnClickListener);
            this.external.setOnClickListener(listenerOnButtonClickedAndroidViewViewOnClickListener);
            this.labs.setOnClickListener(listenerOnButtonClickedAndroidViewViewOnClickListener);
            this.naturalist.setOnClickListener(listenerOnButtonClickedAndroidViewViewOnClickListener);
            this.xray.setOnClickListener(listenerOnButtonClickedAndroidViewViewOnClickListener);
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
            this.value.onButtonClicked(arg0); 
        }
    }
    public static class OnClickListenerImpl1 implements android.view.View.OnClickListener{
        private com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract value;
        public OnClickListenerImpl1 setValue(com.aligmohammad.doctorapp.ui.dialogs.OnDialogInteract value) {
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