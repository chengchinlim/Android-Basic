package com.cheng.android_basic.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonParcelize(val name: String, val arr: List<Double>): Parcelable