package com.aligmohammad.doctorapp.data.network.responses

import android.os.Parcel
import android.os.Parcelable
import com.aligmohammad.doctorapp.data.model.Status
import com.aligmohammad.doctorapp.data.model.User

data class AddAppointmentResponse(
    val appointmentEntity: AppointmentEntity,
    val status: Status
)

data class AppointmentEntity(
    val created: String?,
    val date: String?,
    val doctor: Doctor?,
    val id: Int,
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
        parcel.readInt(),
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
        parcel.writeInt(id)
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

    companion object CREATOR : Parcelable.Creator<AppointmentEntity> {
        override fun createFromParcel(parcel: Parcel): AppointmentEntity {
            return AppointmentEntity(parcel)
        }

        override fun newArray(size: Int): Array<AppointmentEntity?> {
            return arrayOfNulls(size)
        }
    }

}

data class Doctor(
    val appointmentDates: List<String>?,
    val appointmentDurations: List<String>?,
    val appointmentTimes: List<String>?,
    val bio: String?,
    val created: String?,
    val duration: String?,
    val email: String?,
    val id: Int?,
    val image: String?,
    val insuranceNumber: String?,
    val isVerified: Boolean,
    val name: String?,
    val nationalityId: String?,
    val phone: String?,
    val shiftDuration: Int?,
    val updated: String?,
    val username: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(appointmentDates)
        parcel.writeStringList(appointmentDurations)
        parcel.writeStringList(appointmentTimes)
        parcel.writeString(bio)
        parcel.writeString(created)
        parcel.writeString(duration)
        parcel.writeString(email)
        parcel.writeValue(id)
        parcel.writeString(image)
        parcel.writeString(insuranceNumber)
        parcel.writeByte(if (isVerified) 1 else 0)
        parcel.writeString(name)
        parcel.writeString(nationalityId)
        parcel.writeString(phone)
        parcel.writeValue(shiftDuration)
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
