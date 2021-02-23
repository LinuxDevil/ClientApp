package com.aligmohammad.doctorapp.data.network.response

import android.os.Parcel
import android.os.Parcelable

data class AuthResponse(
    val user: User
)

data class User(
    val bio: String?,
    val city: String?,
    val created: String?,
    val district: String?,
    val email: String?,
    val id: Int?,
    val image: String?,
    val insuranceCompany: InsuranceCompany?,
    val insuranceNumber: String?,
    val name: String?,
    val nationalityId: String?,
    val nickname: String?,
    val updated: String?,
    val username: String?,
    val token: String?,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(InsuranceCompany::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bio)
        parcel.writeString(city)
        parcel.writeString(created)
        parcel.writeString(district)
        parcel.writeString(email)
        parcel.writeValue(id)
        parcel.writeString(image)
        parcel.writeParcelable(insuranceCompany, flags)
        parcel.writeString(insuranceNumber)
        parcel.writeString(name)
        parcel.writeString(nationalityId)
        parcel.writeString(nickname)
        parcel.writeString(updated)
        parcel.writeString(username)
        parcel.writeString(token)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}

data class UserModel(
    val bio: String,
    val city: String,
    val created: String,
    val district: String,
    val email: String,
    val id: Int,
    val image: String,
    val insuranceCompany: InsuranceCompany,
    val insuranceNumber: String,
    val name: String,
    val nationalityId: String,
    val nickname: String,
    val updated: String,
    val username: String
)