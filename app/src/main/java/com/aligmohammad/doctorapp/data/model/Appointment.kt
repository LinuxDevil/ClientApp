/*******************************************************************************
 *
 * Copyright RectiCode(c) 2020.
 * All Rights Reserved
 *
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and de-compilation.
 *
 * Created by Ali Mohammad
 *
 ******************************************************************************/

package com.aligmohammad.doctorapp.data.model

import android.os.Parcel
import android.os.Parcelable

data class Appointment(
    var date: DateTime? = DateTime("22/12/2020 Tuesday"),
    var time: DateTime? = DateTime("10:00 - 12:00 PM"),
    var location: String? = "Amman",
    var rate: Int? = 0,
    var imageUrl: String? = "",
    val patient: User? = User("Ali Mohammad"),
    val inProgress: Boolean? = true
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(DateTime::class.java.classLoader),
        parcel.readParcelable(DateTime::class.java.classLoader),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readParcelable(User::class.java.classLoader),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(date, flags)
        parcel.writeParcelable(time, flags)
        parcel.writeString(location)
        parcel.writeValue(rate)
        parcel.writeString(imageUrl)
        parcel.writeParcelable(patient, flags)
        parcel.writeValue(inProgress)
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
