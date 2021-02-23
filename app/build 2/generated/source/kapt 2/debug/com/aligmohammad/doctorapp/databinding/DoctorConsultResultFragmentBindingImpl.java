package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DoctorConsultResultFragmentBindingImpl extends DoctorConsultResultFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.titleTextView, 2);
        sViewsWithIds.put(R.id.resultTextView, 3);
        sViewsWithIds.put(R.id.medicineTextView, 4);
        sViewsWithIds.put(R.id.medicineRecyclerView, 5);
        sViewsWithIds.put(R.id.orderButton, 6);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DoctorConsultResultFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private DoctorConsultResultFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.motion.widget.MotionLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.Button) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[1]
            );
        this.doctorConsultMotionLayout.setTag(null);
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
            setViewModel((com.aligmohammad.doctorapp.ui.fragments.doctorconsultingresult.DoctorConsultResultFragmentViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.aligmohammad.doctorapp.ui.fragments.doctorconsultingresult.DoctorConsultResultFragmentViewModel ViewModel) {
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