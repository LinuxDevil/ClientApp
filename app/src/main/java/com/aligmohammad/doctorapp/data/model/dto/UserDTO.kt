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

package com.aligmohammad.doctorapp.data.model.dto

import android.os.Parcel
import android.os.Parcelable

data class UserDTO(
    var name: String?,
    var email: String?,
    var imageUrl: String?,
    var insuranceNumber: String?,
    var insuranceCompanyId: String?,
    var city: String?,
    var district: String?,
    var nickname: String?,
    var nationalityId: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    constructor() : this("", "", "", "", "", "", "", "", "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(imageUrl)
        parcel.writeString(insuranceNumber)
        parcel.writeString(insuranceCompanyId)
        parcel.writeString(city)
        parcel.writeString(district)
        parcel.writeString(nickname)
        parcel.writeString(nationalityId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDTO> {
        override fun createFromParcel(parcel: Parcel): UserDTO {
            return UserDTO(parcel)
        }

        override fun newArray(size: Int): Array<UserDTO?> {
            return arrayOfNulls(size)
        }
    }
}