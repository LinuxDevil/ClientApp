package com.aligmohammad.doctorapp.data.network.response

import android.os.Parcel
import android.os.Parcelable

data class InsuranceCompany(
    val created: String?,
    val id: Int,
    val nameAr: String?,
    val nameEn: String?,
    val type: String?,
    val updated: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeInt(id)
        parcel.writeString(nameAr)
        parcel.writeString(nameEn)
        parcel.writeString(type)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InsuranceCompany> {
        override fun createFromParcel(parcel: Parcel): InsuranceCompany {
            return InsuranceCompany(parcel)
        }

        override fun newArray(size: Int): Array<InsuranceCompany?> {
            return arrayOfNulls(size)
        }
    }

}