package com.aligmohammad.doctorapp.databinding;
import com.aligmohammad.doctorapp.R;
import com.aligmohammad.doctorapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DoctorProfileFragmentBindingImpl extends DoctorProfileFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.backgroundImage, 9);
        sViewsWithIds.put(R.id.middleSectionLinear, 10);
        sViewsWithIds.put(R.id.rightSection, 11);
        sViewsWithIds.put(R.id.leftSection, 12);
        sViewsWithIds.put(R.id.doctorQualificationsButton, 13);
        sViewsWithIds.put(R.id.reserveTitleBottom, 14);
        sViewsWithIds.put(R.id.lineImage, 15);
        sViewsWithIds.put(R.id.reserveTextView, 16);
        sViewsWithIds.put(R.id.dateTextView, 17);
        sViewsWithIds.put(R.id.dateEditText, 18);
        sViewsWithIds.put(R.id.timeTextView, 19);
        sViewsWithIds.put(R.id.timeEditText, 20);
        sViewsWithIds.put(R.id.confirm_button, 21);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.motion.widget.MotionLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DoctorProfileFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private DoctorProfileFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[9]
            , (android.widget.Button) bindings[21]
            , (android.widget.EditText) bindings[18]
            , (android.widget.TextView) bindings[17]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[1]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            , (com.google.android.material.button.MaterialButton) bindings[13]
            , (android.widget.RatingBar) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[16]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.EditText) bindings[20]
            , (android.widget.TextView) bindings[19]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[8]
            );
        this.doctorImage.setTag(null);
        this.doctorLocation.setTag(null);
        this.doctorMajor.setTag(null);
        this.doctorName.setTag(null);
        this.doctorRating.setTag(null);
        this.doctorRelatedInsurances.setTag(null);
        this.doctorYearsOfExperience.setTag(null);
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
        if (BR.doctor == variableId) {
            setDoctor((com.aligmohammad.doctorapp.data.model.Doctor) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setDoctor(@Nullable com.aligmohammad.doctorapp.data.model.Doctor Doctor) {
        this.mDoctor = Doctor;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.doctor);
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
        java.lang.String doctorRelatedInsurancesGetInt0 = null;
        java.lang.String doctorImageUrl = null;
        java.util.List<java.lang.String> DoctorRelatedInsurances1 = null;
        java.lang.String DoctorMajor1 = null;
        java.lang.String DoctorName1 = null;
        java.lang.String doctorYearsOfExperienceToString = null;
        com.aligmohammad.doctorapp.data.model.Doctor doctor = mDoctor;
        java.lang.Integer DoctorYearsOfExperience1 = null;
        int androidxDatabindingViewDataBindingSafeUnboxDoctorRating = 0;
        java.lang.String doctorLocationName = null;
        java.lang.Integer DoctorRating1 = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (doctor != null) {
                    // read doctor.imageUrl
                    doctorImageUrl = doctor.getImageUrl();
                    // read doctor.relatedInsurances
                    DoctorRelatedInsurances1 = doctor.getRelatedInsurances();
                    // read doctor.major
                    DoctorMajor1 = doctor.getMajor();
                    // read doctor.name
                    DoctorName1 = doctor.getName();
                    // read doctor.yearsOfExperience
                    DoctorYearsOfExperience1 = doctor.getYearsOfExperience();
                    // read doctor.locationName
                    doctorLocationName = doctor.getLocationName();
                    // read doctor.rating
                    DoctorRating1 = doctor.getRating();
                }


                if (DoctorRelatedInsurances1 != null) {
                    // read doctor.relatedInsurances.get(0)
                    doctorRelatedInsurancesGetInt0 = DoctorRelatedInsurances1.get(0);
                }
                if (DoctorYearsOfExperience1 != null) {
                    // read doctor.yearsOfExperience.toString()
                    doctorYearsOfExperienceToString = DoctorYearsOfExperience1.toString();
                }
                // read androidx.databinding.ViewDataBinding.safeUnbox(doctor.rating)
                androidxDatabindingViewDataBindingSafeUnboxDoctorRating = androidx.databinding.ViewDataBinding.safeUnbox(DoctorRating1);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.aligmohammad.doctorapp.util.ViewsKt.loadImage(this.doctorImage, doctorImageUrl);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorLocation, doctorLocationName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorMajor, DoctorMajor1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorName, DoctorName1);
            androidx.databinding.adapters.RatingBarBindingAdapter.setRating(this.doctorRating, androidxDatabindingViewDataBindingSafeUnboxDoctorRating);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorRelatedInsurances, doctorRelatedInsurancesGetInt0);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.doctorYearsOfExperience, doctorYearsOfExperienceToString);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): doctor
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}