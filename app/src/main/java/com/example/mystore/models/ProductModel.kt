package com.example.mystore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
class ProductModel(
    var idProduct:Int,
    var name: String = "",
    var price: Double = 0.0,
    var discount: Int,
    var productPhoto: String,
    var stock: Int
): Parcelable {}


