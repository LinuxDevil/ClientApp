package com.aligmohammad.doctorapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class UserLoginData(
    @SerializedName("username")
    val phoneNumber: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(phoneNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserLoginData> {
        override fun createFromParcel(parcel: Parcel): UserLoginData {
            return UserLoginData(parcel)
        }

        override fun newArray(size: Int): Array<UserLoginData?> {
            return arrayOfNulls(size)
        }
    }
}

data class RegisterLoginData(
    @SerializedName("username")
    val phoneNumber: String? = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(phoneNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterLoginData> {
        override fun createFromParcel(parcel: Parcel): RegisterLoginData {
            return RegisterLoginData(parcel)
        }

        override fun newArray(size: Int): Array<RegisterLoginData?> {
            return arrayOfNulls(size)
        }
    }


}