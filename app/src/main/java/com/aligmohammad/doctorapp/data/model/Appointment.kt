package com.aligmohammad.doctorapp.data.model

import android.os.Parcel
import android.os.Parcelable

data class Appointment(
    val created: String?,
    val date: String?,
    val id: Int,
    val imageUrl: String?,
    val inProgress: Boolean,
    val location: String?,
    val rate: Int,
    val shift: String?,
    val tests: String?,
    val time: String?,
    val updated: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeString(date)
        parcel.writeInt(id)
        parcel.writeByte(if (inProgress) 1 else 0)
        parcel.writeString(location)
        parcel.writeInt(rate)
        parcel.writeString(shift)
        parcel.writeString(tests)
        parcel.writeString(time)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Appointment> {
        override fun createFromParcel(parcel: Parcel): Appointment {
            return Appointment(parcel)
        }

        override fun newArray(size: Int): Array<Appointment?> {
            return arrayOfNulls(size)
        }
    }

}