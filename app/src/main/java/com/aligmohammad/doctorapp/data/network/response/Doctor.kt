package com.aligmohammad.doctorapp.data.network.response

import android.os.Parcel
import android.os.Parcelable

class Doctors : ArrayList<Doctor>()

data class Doctor(
    val appointmentDates: List<String>?,
    val appointmentDurations: List<String>?,
    val appointmentTimes: List<String>?,
    val appointments: List<String>?,
    val bio: String?,
    val created: String?,
    val duration: String?,
    val email: String?,
    val hospital: HospitalResponseItem?,
    val id: Int?,
    val image: String?,
    val insuranceCompany: InsuranceCompany?,
    val insuranceNumber: String?,
    val isVerified: Boolean,
    val name: String?,
    val nationalityId: String?,
    val patients: List<String>?,
    val phone: String?,
    val qalifications: List<String>?,
    val shiftDuration: Int,
    val updated: String?,
    val username: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(HospitalResponseItem::class.java.classLoader),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(InsuranceCompany::class.java.classLoader),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(appointmentDates)
        parcel.writeStringList(appointmentDurations)
        parcel.writeStringList(appointmentTimes)
        parcel.writeStringList(appointments)
        parcel.writeString(bio)
        parcel.writeString(created)
        parcel.writeString(duration)
        parcel.writeString(email)
        parcel.writeParcelable(hospital, flags)
        parcel.writeValue(id)
        parcel.writeString(image)
        parcel.writeParcelable(insuranceCompany, flags)
        parcel.writeString(insuranceNumber)
        parcel.writeByte(if (isVerified) 1 else 0)
        parcel.writeString(name)
        parcel.writeString(nationalityId)
        parcel.writeStringList(patients)
        parcel.writeString(phone)
        parcel.writeStringList(qalifications)
        parcel.writeInt(shiftDuration)
        parcel.writeString(updated)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Doctor> {
        override fun createFromParcel(parcel: Parcel): Doctor {
            return Doctor(parcel)
        }

        override fun newArray(size: Int): Array<Doctor?> {
            return arrayOfNulls(size)
        }
    }

}