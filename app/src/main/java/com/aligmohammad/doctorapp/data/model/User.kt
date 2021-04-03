package com.aligmohammad.doctorapp.data.model

import android.os.Parcel
import android.os.Parcelable


data class User(
    val appointments: String?,
    val bio: String?,
    val city: String?,
    val created: String?,
    val district: String?,
    val email: String?,
    val followee: List<String>?,
    val followers: List<String>?,
    val id: Int,
    val image: String?,
    val insuranceCompany: Int,
    val insuranceNumber: String?,
    val name: String?,
    val nationalityId: String?,
    val nickname: String?,
    val subUsers: List<String>?,
    val token: String?,
    val updated: String?,
    val username: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bio)
        parcel.writeString(city)
        parcel.writeString(created)
        parcel.writeString(district)
        parcel.writeString(email)
        parcel.writeStringList(followee)
        parcel.writeStringList(followers)
        parcel.writeInt(id)
        parcel.writeString(image)
        parcel.writeInt(insuranceCompany)
        parcel.writeString(insuranceNumber)
        parcel.writeString(name)
        parcel.writeString(nationalityId)
        parcel.writeString(nickname)
        parcel.writeStringList(subUsers)
        parcel.writeString(token)
        parcel.writeString(updated)
        parcel.writeString(username)
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