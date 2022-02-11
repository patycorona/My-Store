package com.example.mystore.models

import com.google.gson.annotations.SerializedName

class ApiHitModel (
    @SerializedName("idProduct") val idProduct: Int = 0,
    @SerializedName("name") var name : String = "",
    @SerializedName("price") var price: Double = 0.0,
    @SerializedName("discount") val discount: Int = 0,
    @SerializedName("productPhoto") val productPhoto: String ="",
    @SerializedName("stock") val stock: Int =0
)

