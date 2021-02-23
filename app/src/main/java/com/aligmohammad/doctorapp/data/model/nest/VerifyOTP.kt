package com.aligmohammad.doctorapp.data.model.nest

import android.os.Parcel
import android.os.Parcelable

data class VerifyOTP(
    val phoneNumber: String? = "",
    val code: String? =  ""
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(phoneNumber)
        parcel.writeString(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VerifyOTP> {
        override fun createFromParcel(parcel: Parcel): VerifyOTP {
            return VerifyOTP(parcel)
        }

        override fun newArray(size: Int): Array<VerifyOTP?> {
            return arrayOfNulls(size)
        }
    }

}
