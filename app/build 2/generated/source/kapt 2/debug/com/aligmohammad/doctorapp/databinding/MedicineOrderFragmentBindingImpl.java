package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MedicineOrderFragmentBindingImpl extends MedicineOrderFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.medicineTextView, 2);
        sViewsWithIds.put(R.id.medicineRecyclerView, 3);
        sViewsWithIds.put(R.id.selectLocation, 4);
        sViewsWithIds.put(R.id.locationEditText, 5);
        sViewsWithIds.put(R.id.selectPharmacy, 6);
        sViewsWithIds.put(R.id.pharmacySpinner, 7);
        sViewsWithIds.put(R.id.selectDeliveryOption, 8);
        sViewsWithIds.put(R.id.deliveryOptionSpinner, 9);
        sViewsWithIds.put(R.id.totalTextView, 10);
        sViewsWithIds.put(R.id.orderButton, 11);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.motion.widget.MotionLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MedicineOrderFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private MedicineOrderFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Spinner) bindings[9]
            , (android.widget.EditText) bindings[5]
            , (androidx.recyclerview.widget.RecyclerView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (android.widget.Button) bindings[11]
            , (android.widget.Spinner) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[6]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[1]
            , (android.widget.TextView) bindings[10]
            );
        this.mboundView0 = (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0];
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
            setViewModel((com.aligmohammad.doctorapp.ui.fragments.medicineorder.MedicineOrderViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.aligmohammad.doctorapp.ui.fragments.medicineorder.MedicineOrderViewModel ViewModel) {
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
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}