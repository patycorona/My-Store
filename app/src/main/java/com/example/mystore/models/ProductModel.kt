package com.example.mystore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

//@RawValue
data class ProductModel(
    var hits: MutableList<Product> = mutableListOf(),
    val page: Int = 0,
    val totalPages: Int = 0,
    val hitsPerPage: Int = 0
)