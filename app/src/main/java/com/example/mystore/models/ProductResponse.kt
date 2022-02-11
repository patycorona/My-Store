package com.example.mystore.models

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("id_product_unique") val idProduct: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("price") val price: Double = 0.0,
    @SerializedName("discount") val discount: Int = 0,
    @SerializedName("image_photo_product_work") val productPhoto: String = "",
    @SerializedName("stock") val stock: Int = 0,
)