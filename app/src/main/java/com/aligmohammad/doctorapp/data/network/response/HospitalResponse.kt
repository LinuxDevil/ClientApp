package com.aligmohammad.doctorapp.data.network.response

import android.os.Parcel
import android.os.Parcelable

data class HospitalResponse(
    val hospitals: ArrayList<HospitalResponseItem>,
    val length: Int?,
    val hospitalNames: ArrayList<String>
)

data class HospitalResponseItem(
    val appointmentDates: List<String>?,
    val appointmentDurations: List<String>?,
    val appointmentTimes: List<String>?,
    val created: String?,
    val doctors: List<Doctor>?,
    val duration: String?,
    val email: String?,
    val endTime: String?,
    val holidays: List<String>?,
    val id: Int,
    val imageUrl: String?,
    val insurances: List<String>?,
    val isAvialable: Boolean?,
    val location: Location?,
    val nameAr: String?,
    val nameEn: String?,
    val phone: String?,
    val shiftDuration: Int,
    val startTime: String?,
    val type: String?,
    val updated: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.createTypedArrayList(Doctor),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readParcelable(Location::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(appointmentDates)
        parcel.writeStringList(appointmentDurations)
        parcel.writeStringList(appointmentTimes)
        parcel.writeString(created)
        parcel.writeTypedList(doctors)
        parcel.writeString(duration)
        parcel.writeString(email)
        parcel.writeString(endTime)
        parcel.writeStringList(holidays)
        parcel.writeInt(id)
        parcel.writeString(imageUrl)
        parcel.writeStringList(insurances)
        parcel.writeValue(isAvialable)
        parcel.writeParcelable(location, flags)
        parcel.writeString(nameAr)
        parcel.writeString(nameEn)
        parcel.writeString(phone)
        parcel.writeInt(shiftDuration)
        parcel.writeString(startTime)
        parcel.writeString(type)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HospitalResponseItem> {
        override fun createFromParcel(parcel: Parcel): HospitalResponseItem {
            return HospitalResponseItem(parcel)
        }

        override fun newArray(size: Int): Array<HospitalResponseItem?> {
            return arrayOfNulls(size)
        }
    }

}

data class Location(
    val created: String?,
    val id: Int,
    val nameAr: String?,
    val nameEn: String?,
    val updated: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(created)
        parcel.writeInt(id)
        parcel.writeString(nameAr)
        parcel.writeString(nameEn)
        parcel.writeString(updated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }

}