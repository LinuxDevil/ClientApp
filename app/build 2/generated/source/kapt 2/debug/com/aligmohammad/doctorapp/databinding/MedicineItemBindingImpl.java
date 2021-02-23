package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class MedicineItemBindingImpl extends MedicineItemBinding  {

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
    private final androidx.cardview.widget.CardView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MedicineItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private MedicineItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.medicineName.setTag(null);
        this.price.setTag(null);
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
        if (BR.medicine == variableId) {
            setMedicine((com.aligmohammad.doctorapp.data.model.Medicine) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMedicine(@Nullable com.aligmohammad.doctorapp.data.model.Medicine Medicine) {
        this.mMedicine = Medicine;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.medicine);
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
        java.lang.String medicineCurrency = null;
        java.lang.String medicinePriceToStringConcatMedicineCurrency = null;
        java.lang.Double medicinePrice = null;
        java.lang.String MedicineName1 = null;
        java.lang.String medicinePriceToString = null;
        com.aligmohammad.doctorapp.data.model.Medicine medicine = mMedicine;

        if ((dirtyFlags & 0x3L) != 0) {



                if (medicine != null) {
                    // read medicine.currency
                    medicineCurrency = medicine.getCurrency();
                    // read medicine.price
                    medicinePrice = medicine.getPrice();
                    // read medicine.name
                    MedicineName1 = medicine.getName();
                }


                if (medicinePrice != null) {
                    // read medicine.price.toString()
                    medicinePriceToString = medicinePrice.toString();
                }


                if (medicinePriceToString != null) {
                    // read medicine.price.toString().concat(medicine.currency)
                    medicinePriceToStringConcatMedicineCurrency = medicinePriceToString.concat(medicineCurrency);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.medicineName, MedicineName1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.price, medicinePriceToStringConcatMedicineCurrency);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): medicine
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}