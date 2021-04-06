package com.aligmohammad.doctorapp.data.network.responses

import android.os.Parcel
import android.os.Parcelable
import com.aligmohammad.doctorapp.data.model.User

data class AppointmentResponse(
    val created: String?,
    val date: String?,
    val doctor: Doctor?,
    val id: Int?,
    val imageUrl: String?,
    val inProgress: Boolean,
    val location: String?,
    val rate: Int,
    val shift: String?,
    val tests: String?,
    val time: String?,
    val updated: String?,
    val user: User?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Doctor::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(User::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeString(date)
        parcel.writeParcelable(doctor, flags)
        parcel.writeValue(id)
        parcel.writeString(imageUrl)
        parcel.writeByte(if (inProgress) 1 else 0)
        parcel.writeString(location)
        parcel.writeInt(rate)
        parcel.writeString(shift)
        parcel.writeString(tests)
        parcel.writeString(time)
        parcel.writeString(updated)
        parcel.writeParcelable(user, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppointmentResponse> {
        override fun createFromParcel(parcel: Parcel): AppointmentResponse {
            return AppointmentResponse(parcel)
        }

        override fun newArray(size: Int): Array<AppointmentResponse?> {
            return arrayOfNulls(size)
        }
    }

}
