package com.jetpackio.navigationmaster

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val name: String?,
    val value: Int?
) : Parcelable